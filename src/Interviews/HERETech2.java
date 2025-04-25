package Interviews;

public class HERETech2 {
    public static void main(String[] args) {

        //Given an integer array nums, find a subarray that has the largest product, and return the product.
        //[2,3,-2,4] = 6

//        int[] input = new int[]{-1, 6, 0, -2, 6};
        int[] input = new int[]{2,3,-2, 4, -2};

        System.out.println(findSubarrayProduct(input));




    }

    private static int findSubarrayProduct(int[] input) {

        int currMax = 1;
        int maxProduct = 0;

        for (int j : input) {
            currMax = currMax * j;
            if(j == 0)
                    currMax = 1;
//            currMax = Math.max(j, currMax);
            maxProduct = Math.max(maxProduct, currMax);
        }
        return maxProduct;
    }
}



//PID Name:
//
//1 Milind
//2 @Ashwin
//3 Milind

//O/p Milind


// Select s.Name from emp s group by name where count(s.Name) = max (s.Name);
