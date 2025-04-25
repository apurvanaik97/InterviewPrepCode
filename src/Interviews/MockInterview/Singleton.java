package Interviews.MockInterview;

public class Singleton {
    private Singleton() {
        System.out.println("Singleton instance created");
    }

    private static class Holder {
        static {
            System.out.println("Holder class initialized");
        }
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        System.out.println("getInstance() called");
        return Holder.INSTANCE;
    }

    public static void main(String[] args) {
        System.out.println("Main started");
        Singleton.getInstance();
    }
}