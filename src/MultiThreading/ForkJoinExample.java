package MultiThreading;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private final int[] arr;
    private final int start, end;
    private static final int THRESHOLD = 5; // Optimal threshold

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println("Computing sum from index " + start + " to " + end);
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            System.out.println("Computed sum: " + sum + " for range [" + start + "," + end + "]");
            return sum;
        }

        int mid = (start + end) / 2;
        SumTask leftTask = new SumTask(arr, start, mid);
        SumTask rightTask = new SumTask(arr, mid, end);

        leftTask.fork();
        rightTask.fork();

        int leftResult = leftTask.join();
        int rightResult = rightTask.join();

        System.out.println("Merging results: " + leftResult + " + " + rightResult + " = " + (leftResult + rightResult));
        return leftResult + rightResult;
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
//        int[] arr = new int[20];  // Large array
//        for (int i = 0; i < arr.length; i++) arr[i] = i + 1;
//
//        ForkJoinPool pool = new ForkJoinPool();
//        int result = pool.invoke(new SumTask(arr, 0, arr.length));
//
//        System.out.println("Final Total Sum: " + result);  // Should print 210
//

//
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
//        map.put("Java", 10);
//        map.put("Python", 8);
//
//        Runnable task = () -> map.compute("Java", (k, v) -> v + 1); // Thread-safe update
//
//        Thread t1 = new Thread(task);
//        Thread t2 = new Thread(task);
//        t1.start();
//        t2.start();
//
//        try {
//            t1.join();
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Updated Java Score: " + map.get("Java"));





        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>(new String[]{"A", "B", "C"});

        for (String item : list) {
            System.out.println(item);
            list.add("D"); // ✅ No ConcurrentModificationException
        }

        System.out.println("Final List: " + list);
    }
}

