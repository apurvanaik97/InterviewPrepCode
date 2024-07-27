package SortingAlgo;

public class SelectionSort {
    public static void main(String[] args) {

        // Cases            Best Case       Worst Case      Average
        //Time complexity = O[n*n]          O[n*n]        O[n*n]
        //Space complexity = O[1]
        int[] input = {1, 4, 3, 5, 6, 7};
        int length = input.length;
        int temp;
        int minIndex;

        System.out.print("Before Sorting ");

        for (int i : input) {
            System.out.print(i + " ");
        }

        System.out.println(" ");

        for(int i =0; i < length-1; i++){
            minIndex = i;
            for(int j = i+ 1; j < length; j++){
                if(input[minIndex] > input[j]){
                    minIndex = j;
                }
            }
            temp = input[i];
            input[i] = input[minIndex];
            input[minIndex] = temp;
        }

        System.out.print("After Sorting ");

        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}
