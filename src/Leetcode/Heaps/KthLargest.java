package Leetcode.Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargest {
    public int[][] kClosest(int[][] points, int K) {
        // Max-Heap (priority queue) with custom comparator (based on squared distance)
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );

        // Add all points to the heap and maintain the heap size of K
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > K) {
                maxHeap.poll();  // Remove the farthest point if size exceeds K
            }
        }

        // Convert the heap into the result array
        int[][] result = new int[K][2];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        KthLargest solution = new KthLargest();

        // Example points (x, y)
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int K = 2;  // We want to find the 2 closest points to the origin

        // Find the K closest points
        int[][] result = solution.kClosest(points, K);

        // Print the K closest points
        System.out.println("K closest points:");
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}

