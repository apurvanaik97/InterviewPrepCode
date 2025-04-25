package Leetcode.Blind75;

public class CountingBits {
    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        countingBits.countBits(2);

    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        if(n == 0){
            return new int[0];
        }
        if(n ==1){
            result[0] = 1;
            return result;
        }
        for(int i =0; i <= n ; i++){

            if(i%2 == 0){
                result[i] = result[i >> 1];
            }else{
                result[i] = result[i-1] + 1;
            }
        }

        for(int i =0 ; i <= n; i++){
            System.out.println(result[i]);
        }
        return result;
    }
}
