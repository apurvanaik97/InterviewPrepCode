package SortingAlgo;

public class BubbleSort {
    public static void main(String[] args) {

        // Cases            Best Case       Worst Case      Average
        //Time complexity = O[n*n]          O[n*n]        O[n*n]
        //Space complexity = O[1]
        int[] input = {1, 4, 3, 5, 6, 7};
        int length = input.length;
        int temp;

        System.out.print("Before Sorting ");

        for (int i : input) {
            System.out.print(i + " ");
        }

        System.out.println(" ");

        for (int i = 0; i < length; i++){
            for( int j = 0; j < length-1-i; j++){
                if(input[j] > input[j+1]){
                    temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }

        System.out.print("After Sorting ");

        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
