package MultiThreading;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {




        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);

        CompletableFuture<Void> pipeline = future1.thenApplyAsync(x -> {
            IntStream.range(0, 20).forEachOrdered(n -> {
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(n);
            });
            return 8;
        }).thenAccept(result -> System.out.println("ASync Result 1 : " + result));

        pipeline.get(); // ✅ Ensures full completion before exiting

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);
//
//        future.thenApply(x -> {
//                    IntStream.range(0, 20).forEachOrdered(n -> {
//                        try {
//                            Thread.sleep(7);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                        System.out.println(n);
//                    });
//                    return 8;
//        }).thenAccept(result -> System.out.println("Sync Result: " + result)); // Runs synchronously

        future.thenApplyAsync(x -> {
            IntStream.range(0, 20).forEachOrdered(n -> {
                try {
                    Thread.sleep(7);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(n);
            });
            return 8;
        }).thenAccept(result -> System.out.println("ASync Result: " + result)); // Runs Asynchronously

        future.get();

//        future.thenApplyAsync(x -> x * 2) // Runs asynchronously
//                .thenAccept(result -> System.out.println("Async Result: " + result));
//
//        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("Fetching data from TASK 1...");
//            return "Behavior : Result from API TASK 1";
//        }).thenApply(v -> v.toLowerCase(Locale.CHINA)).handle(  (a,e) -> {
//            System.out.println( "TEST");
//            return a;
//        });


//
//        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
//            System.out.println("Fetching data task2");
//
//        });
//
////        System.out.println(task1.complete("HEREEE"));
//        System.out.println(task1.get());
    }

//    public static void main(String[] args) {
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//            System.out.println("Executing Async Task: " + Thread.currentThread().getName());
//        });
//
////        future.join(); // Waits for completion
//    }
}

