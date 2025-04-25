package ConcentricAI;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MatrixTraversal {

    // Directions for moving in the matrix: Up, Down, Left, Right
    private static final int[] rowDirs = {-1, 1, 0, 0}; // Row changes for Up and Down
    private static final int[] colDirs = {0, 0, -1, 1}; // Column changes for Left and Right

    // Function to check if we can reach the bottom-right corner (m-1, n-1)
    public static boolean canReachEnd(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // If the matrix is empty or the start point is blocked, return false
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] == 0) {
            return false;
        }

        // Queue to store cells to be explored, starting with (0, 0)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});  // Add the start point to the queue

        // 2D array to track visited cells
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;  // Mark the start cell as visited

        // Process the queue until all possible cells are explored
        while (!queue.isEmpty()) {
            // Get the current cell to explore
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            // If we reach the bottom-right corner, return true
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return true; // Reached the bottom-right corner
            }

            // Explore the four possible directions (Up, Down, Left, Right)
            for (int i = 0; i < 4; i++) {
                // Calculate the new cell position
                int newRow = currentRow + rowDirs[i];
                int newCol = currentCol + colDirs[i];

                // Check if the new cell is within bounds, not visited, and open space (1)
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && !visited[newRow][newCol] && matrix[newRow][newCol] == 1) {

                    // Mark the new cell as visited and add it to the queue
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // If we finish the BFS without reaching the bottom-right corner, return false
        return false;
    }

    public static void main(String[] args) {
        // Example matrix where 1 means open space and 0 means blocked
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1}
        };

        // Check if we can reach the bottom-right corner starting from (0, 0)
        if (canReachEnd(matrix)) {
            System.out.println("It is possible to reach the bottom-right corner.");
        } else {
            System.out.println("It is not possible to reach the bottom-right corner.");
        }

    }
}
