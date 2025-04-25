package Misc;
import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();


        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApply(result -> result + " World")
                .thenAccept(System.out::println);
        for (int i = 0; i < 99; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task.");
            });
        }

        executor.shutdown();
    }
}

