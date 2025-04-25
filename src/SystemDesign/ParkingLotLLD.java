package SystemDesign;

import java.util.*;

public class ParkingLotLLD {
        public static void main(String[] args) throws InterruptedException {
            ParkingLot lot = ParkingLot.getInstance();
            ParkingFloor floor = new ParkingFloor("F1");
            floor.addSpot(new CarSpot("C1"));
            floor.addSpot(new CarSpot("C2"));
            lot.addFloor(floor);

            Vehicle vehicle = new Vehicle("KA01AB1234", VehicleType.CAR);
            Ticket ticket = lot.generateTicket(vehicle);

            System.out.println("Ticket generated for: " + vehicle.getLicenseNumber());
            System.out.println("TicketId " + ticket.getTicketId());

            Thread.sleep(2000); // Simulate time spent in parking

            double charges = lot.processExit(ticket.getTicketId());
            System.out.println("Charges: Rs." + charges);
        }
}
// Enums
enum VehicleType {
    BIKE, CAR, TRUCK;
}

enum ParkingSpotType {
    BIKE, CAR, TRUCK;
}

// Vehicle
class Vehicle {
    private String licenseNumber;
    private VehicleType type;

    public Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }
}

// Abstract ParkingSpot
abstract class ParkingSpot {
    protected String id;
    protected boolean isFree;
    protected Vehicle vehicle;
    protected ParkingSpotType type;

    public ParkingSpot(String id, ParkingSpotType type) {
        this.id = id;
        this.type = type;
        this.isFree = true;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        if (!isFree) return false;
        this.vehicle = vehicle;
        this.isFree = false;
        return true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}

class BikeSpot extends ParkingSpot {
    public BikeSpot(String id) {
        super(id, ParkingSpotType.BIKE);
    }
}

class CarSpot extends ParkingSpot {
    public CarSpot(String id) {
        super(id, ParkingSpotType.CAR);
    }
}

class TruckSpot extends ParkingSpot {
    public TruckSpot(String id) {
        super(id, ParkingSpotType.TRUCK);
    }
}

// Ticket
class Ticket {
    private String ticketId;
    private Date entryTime;
    private Date exitTime;
    private ParkingSpot spot;
    private Vehicle vehicle;

    public Ticket(String ticketId, Date entryTime, ParkingSpot spot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.spot = spot;
        this.vehicle = vehicle;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public long getDurationInHours() {
        long duration = exitTime.getTime() - entryTime.getTime();
        return Math.max(1, duration / (1000 * 60 * 60));
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getTicketId(){
        return ticketId;
    }
}

// ParkingRate
class ParkingRate {
    public static double calculateCharges(VehicleType type, long hours) {
        switch (type) {
            case BIKE: return hours * 10;
            case CAR: return hours * 20;
            case TRUCK: return hours * 30;
            default: return hours * 15;
        }
    }
}

// ParkingFloor
class ParkingFloor {
    private String floorId;
    private Map<ParkingSpotType, List<ParkingSpot>> spotMap;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        spotMap = new HashMap<>();
        for (ParkingSpotType type : ParkingSpotType.values()) {
            spotMap.put(type, new ArrayList<>());
        }
    }

    public void addSpot(ParkingSpot spot) {
        spotMap.get(spot.getType()).add(spot);
    }

    public ParkingSpot getFreeSpot(VehicleType vehicleType) {
        ParkingSpotType spotType = ParkingSpotType.valueOf(vehicleType.name());
        for (ParkingSpot spot : spotMap.get(spotType)) {
            if (spot.isFree()) return spot;
        }
        return null;
    }
}

// ParkingLot (Singleton)
class ParkingLot {
    private static ParkingLot instance = null;
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;

    private ParkingLot() {
        floors = new ArrayList<>();
        activeTickets = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) instance = new ParkingLot();
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Ticket generateTicket(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getFreeSpot(vehicle.getType());
            if (spot != null) {
                spot.assignVehicle(vehicle);
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), new Date(), spot, vehicle);
                activeTickets.put(ticket.getTicketId(), ticket);
                return ticket;
            }
        }
        return null; // no spot found
    }

    public double processExit(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) return -1;
        ticket.setExitTime(new Date());
        ticket.getSpot().removeVehicle();
        activeTickets.remove(ticketId);
        return ParkingRate.calculateCharges(ticket.getVehicle().getType(), ticket.getDurationInHours());
    }
}
