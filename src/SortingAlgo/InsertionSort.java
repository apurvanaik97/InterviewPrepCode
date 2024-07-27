package SortingAlgo;

public class InsertionSort {
    public static void main(String[] args) {

        // Cases            Best Case       Worst Case      Average
        //Time complexity = O[n]          O[n*n]        O[nlogn]
        //Space complexity = O[1]
        int[] input = {1, 4, 3, 5, 6, 7};
        int length = input.length;
        int key;
        int j;

        System.out.print("Before Sorting ");

        for (int in : input) {
            System.out.print(in + " ");
        }

        System.out.println(" ");

        for(int i =0; i < length; i++){
            key = input[i];
             j = i-1;
             while( j>=0 && input[j] > key ){
                 input[j+1] = input[j];
                 j = j-1;
             }
             input[j+1] = key;
        }

        System.out.print("After Sorting ");

        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
