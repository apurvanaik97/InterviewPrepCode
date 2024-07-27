package SortingAlgo;

public class QuickSort {
    public static void main(String[] args) {
        // Cases            Best Case       Worst Case      Average
        //Time complexity = O[nlogn]          O[n*n]        O[nlogn]
        //Space complexity = O[logn]
        int[] input = {1, 4, 3, 5, 6, 7};
        int length = input.length -1 ;

        System.out.print("Before Sorting ");

        for (int in : input) {
            System.out.print(in + " ");
        }

        System.out.println(" ");

        quickSort(input, 0, length);

        System.out.print("After Sorting ");

        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low< high){

            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi+1 , high);
        }

    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
}
