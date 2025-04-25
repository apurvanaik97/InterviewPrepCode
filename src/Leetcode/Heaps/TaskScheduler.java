package Leetcode.Heaps;



import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        Map<Character, Integer> taskCount = new HashMap<>();
        for (char task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
        }

        // Step 2: Max-Heap to store the frequencies of tasks (task, frequency)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : taskCount.values()) {
            maxHeap.offer(count);
        }

        int time = 0;
        // Step 3: Simulate the task execution process
        while (!maxHeap.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            // Step 4: Iterate over a time window of size n+1
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int taskFrequency = maxHeap.poll();
                    if (taskFrequency > 1) {
                        tempList.add(taskFrequency - 1);
                    }
                }
                time++;
                // If all tasks are completed, we don't need to wait any longer
                if (maxHeap.isEmpty() && tempList.isEmpty()) {
                    break;
                }
            }

            // Step 5: Reinsert the tasks back into the max heap
            for (int freq : tempList) {
                maxHeap.offer(freq);
            }
        }

        return time;
    }

    public static void main(String[] args) {
        TaskScheduler solution = new TaskScheduler();

        // Example input
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;  // Cooldown period

        // Find the least time to finish all tasks
        int result = solution.leastInterval(tasks, n);

        // Print the result
        System.out.println("Minimum time to complete all tasks: " + result);
    }
}
