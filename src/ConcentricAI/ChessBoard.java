package ConcentricAI;

import java.util.Scanner;

public class ChessBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter value of m");

        int m = sc.nextInt();

        System.out.println("Enter value of n");

        int n = sc.nextInt();


        System.out.println("Enter value of m x n matrix");

        int[][] input = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = sc.nextInt();
            }
        }

        System.out.println("Input matrix : ");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(input[i][j]);
            }
        }

        System.out.println(checkIfPossible(input, m, n));
    }

    private static boolean checkIfPossible(int[][] input, int m, int n) {

        if (input[0][0] != 1 || input[m][n] != 1 || input[1][0] != 1 || input[0][1] != 1) {
            return false;
        }

//        || input[m][0] != 1 || input[0][m] != 1

        int temp = 0;
        for (int i = 1; i < m; i++) {
            while( temp < n){
                if (input[i][temp] != 1) {
                    temp++;
                }
            }

        }


        return true;
    }
}
