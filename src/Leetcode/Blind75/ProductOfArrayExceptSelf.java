package Leetcode.Blind75;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
    ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
    Arrays.stream(productOfArrayExceptSelf.productExceptSelf(new int[]{-1,1,0,-3,3})).boxed().forEach(System.out::print);

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1 ; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int suffix = 1;

        for(int i = nums.length -1 ; i >= 0; i--){
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }
        return result;

    }
}