package MultiThreading;
class ThreadLocalExample {
    private static final ThreadLocal<Integer> threadLocalID = ThreadLocal.withInitial(() -> (int) (Math.random() * 10));


    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " - ID: " + threadLocalID.get());
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 2");
        Thread t4 = new Thread(task, "Thread 3");
        Thread t5 = new Thread(task, "Thread 4");
        Thread t6 = new Thread(task, "Thread 5");
        Thread t7 = new Thread(task, "Thread 7");
        Thread t8 = new Thread(task, "Thread 8");
        Thread t9 = new Thread(task, "Thread 9");
        Thread t10 = new Thread(task, "Thread 10");



        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}

