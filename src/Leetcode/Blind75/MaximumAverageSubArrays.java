package Leetcode.Blind75;

public class MaximumAverageSubArrays {
    public static void main(String[] args) {
        MaximumAverageSubArrays maximumAverageSubArrays = new MaximumAverageSubArrays();
        maximumAverageSubArrays.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
    }
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        int i = 0;
        int sum = 0;
        for(i = 0; i < k; i++){
            sum+= nums[i];
        }
        max = Math.max(max, sum / (double)k);
        while(i < nums.length){
            sum = sum - nums[i -k] + nums[i];
            max = Math.max(max, sum / (double)k);
            i++;
        }

        return max;

    }

}
