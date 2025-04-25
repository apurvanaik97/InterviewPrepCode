package Interviews;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

enum Status {PENDING, COMPLETED, FAILED}

public class PublicisSapient {
    // package whatever; // don't place package name!
    public static void main(String[] args) {
        System.out.println("Hello Java");

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", 500.0, LocalDateTime.now(), Status.COMPLETED),

                new Transaction("T2", 1500.0, LocalDateTime.now(), Status.COMPLETED),

                new Transaction("T3", 800.0, LocalDateTime.now(), Status.FAILED),

                new Transaction("T4", 2200.0, LocalDateTime.now(), Status.COMPLETED),

                new Transaction("T5", 600.0, LocalDateTime.now(), Status.PENDING),

                new Transaction("T6", 3300.0, LocalDateTime.now(), Status.COMPLETED),

                new Transaction("T7", 700.0, LocalDateTime.now(), Status.COMPLETED)

        );
        // System.out.println(transactions.stream().filter(x -> x.getStatus() == Status.COMPLETED).collect(Collectors.toList()));



    }
}

class Transaction {
    private String transactionId;
    private double amount;
    private LocalDateTime timestamp;
    private Status status;

    public Transaction(String transactionId, double amount, LocalDateTime timestamp, Status status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "{Id=" + transactionId + ", Amount=" + amount + ", Status=" + status + "}";
    }
}



