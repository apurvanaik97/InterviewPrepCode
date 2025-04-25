package Leetcode.Blind75;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{2,2,1}));
    }
    public int singleNumber(int[] nums) {
        if(nums == null){
            return 0;
        }
        int result = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
