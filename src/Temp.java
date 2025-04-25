import java.util.*;
class Temp {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int k = 0, m = matrix.length, n = matrix[0].length , md = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        int row = 0, col = 0;
        while(k < Math.max(m, n)){

            result.add(matrix[row][col]);
            while(col <= n-2){
                col++;
                result.add(matrix[row][col]);
            }

            while(row <= m -2){
                row++;
                result.add(matrix[row][col]);
            }

            while(col >= 1){
                col--;
                result.add(matrix[row][col]);
            }

            while(row <= m-1- k){
                k++;
                row --;
                result.add(matrix[row][col]);

            }

        }
    return result;
    }


    public static void main(String[] args) {
//        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});

        Integer p = 1000;
        Integer q = 1000;
        System.out.println(p == q);

    }
}


