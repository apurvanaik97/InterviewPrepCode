package Leetcode.Blind75;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestFromArray {
    public static void main(String[] args) {
        KthLargestFromArray kthLargestFromArray = new KthLargestFromArray();
        kthLargestFromArray.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i : nums){

            minHeap.offer(i);
           if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
