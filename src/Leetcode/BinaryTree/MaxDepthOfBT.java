package Leetcode.BinaryTree;

import Leetcode.TreeNode;

public class MaxDepthOfBT {


    // DFS approach to find maximum depth
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Recursively compute the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum of the two depths plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        MaxDepthOfBT solution = new MaxDepthOfBT();

        // Example tree: [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Find maximum depth
        int maxDepth = solution.maxDepth(root);
        System.out.println("Maximum Depth: " + maxDepth);  // Output: 3

        solution.travrseTree(root);
    }

    private void travrseTree(TreeNode root) {
        if(root != null) {
            System.out.println(root.val);
            if(root.left != null){
                System.out.println(root.left.val);
            }
            if(root.right != null){
                System.out.println(root.right.val);
            }
            if(root.left!=null){
                travrseTree(root.left);
            }

            if(root.right!=null){
                travrseTree(root.right);
            }

        }
    }
}
