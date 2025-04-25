package Leetcode.Blind75;

public class FindPivotIndex {
    public static void main(String[] args) {
        FindPivotIndex pivotIndex = new FindPivotIndex();
        System.out.println(pivotIndex.pivotIndex(new int[]{1,2,3}));
    }
    public int pivotIndex(int[] nums) {
        int length = nums.length;

        int[] prefix = new int[length + 1];
        
        prefix[0] = nums[0];
        
        for(int i =1 ; i < length; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        int[] suffix = new int[length +1];
        
        suffix[length -1] = nums[length-1];

        for(int i = length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] + nums[i];
        }

        for(int i = 0 ; i < length; i++){
            if(prefix[i] == suffix[i]){
                return i;
            }
        }
        return -1;
    }
}


//            System.out.println("i : " + i + "----PREFIX : " + prefix[i] + " --- SUFFIX : " + suffix[i]);
