package Misc;

class PrintNumbers {
    private int number = 1;
    private final Object lock = new Object();

    public void printOdd() {
        synchronized (lock) {
            while (number <= 10) {
                if (number % 2 != 0) {
                    System.out.println("Odd: " + number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= 10) {
                if (number % 2 == 0) {
                    System.out.println("Even: " + number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();

        Thread oddThread = new Thread(printNumbers::printOdd);
        Thread evenThread = new Thread(printNumbers::printEven);

        oddThread.start();
        evenThread.start();
    }
}
