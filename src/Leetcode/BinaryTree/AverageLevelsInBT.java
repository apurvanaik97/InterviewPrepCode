package Leetcode.BinaryTree;


import Leetcode.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class AverageLevelsInBT {
    // Method to build the tree from the given level-order array
    public TreeNode buildTree(Integer[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(input[0]);  // root node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // Add root to the queue
        int index = 1; // Start with the second element (children of root)

        while (index < input.length) {
            TreeNode currentNode = queue.poll();  // Get the next node in the queue

            // Left child
            if (input[index] != null) {
                currentNode.left = new TreeNode(input[index]);
                queue.offer(currentNode.left);  // Add left child to the queue
            }
            index++;

            // Right child
            if (index < input.length && input[index] != null) {
                currentNode.right = new TreeNode(input[index]);
                queue.offer(currentNode.right);  // Add right child to the queue
            }
            index++;
        }

        return root;
    }

    // Method to calculate average of nodes at each level of the tree
    private static TreeNode invertedBT(TreeNode root) {

        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i =0 ; i < levelSize; i++){
                TreeNode currentNode = queue.poll();

                // Swap the left and right children
                assert currentNode != null;
                TreeNode temp = currentNode.left;
                currentNode.left = currentNode.right;
                currentNode.right = temp;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }

        }
    return root;
    }

    private List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            List<Integer> temp = new ArrayList<>();
            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                assert currentNode != null;
                temp.add(currentNode.val);

                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(temp);

        }
        return result;

    }

    private static boolean checkIfTreesAreSame(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.offer(root1);
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.offer(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode currentQ1 = queue1.poll();
            TreeNode currentQ2 = queue2.poll();
            if(currentQ1.val != currentQ2.val){
                return false;
            }

            if (currentQ1.left != null) {
                queue1.offer(currentQ1.left);
            } else if (currentQ2.left != null) {
                return false; // If one tree has left child and the other doesn't
            }

            if (currentQ1.right != null) {
                queue1.offer(currentQ1.right);
            } else if (currentQ2.right != null) {
                return false; // If one tree has right child and the other doesn't
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) {
            return result;
        }

        // Queue for level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            double levelSum = 0;

            // Process each node at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // Add children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Calculate the average for this level and add it to the result list
            result.add(levelSum / levelSize);
        }

        return result;
    }

    public static void main(String[] args) {
        AverageLevelsInBT solution = new AverageLevelsInBT();

        // Input: [3, 9, 20, null, null, 15, 7]
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        Integer[] input1 = {3, 9, 20, null, null, 15, 7};
        Integer[] input2 = {3, 9, 20, null, null, 15, 7};
        Integer[] input3 = {4, 2, 7, 1, 3};

        // Build the tree from the level-order input
        TreeNode root = solution.buildTree(input);
        TreeNode root1 = solution.buildTree(input1);
        TreeNode root2 = solution.buildTree(input2);
        TreeNode root3 = solution.buildTree(input3);

        // Now, calculate the average of each level
//        List<Double> averages = solution.averageOfLevels(root);
//        List<List<Integer>> levelOrder = solution.levelOrderTraversal(root);

        // Output the result
//        System.out.println(checkIfTreesAreSame(root1 , root2));  // Output: [3.0, 14.5, 11.0]
//        System.out.println(invertedBT(root));  // Output: [3.0, 14.5, 11.0]
        System.out.println(searchBST(root3, 2));  // Output: [3.0, 14.5, 11.0]
    }

    private static TreeNode searchBST(TreeNode root, Integer val) {


        if (root == null || root.val == val) {
            return root;
        }

        // If the target value is less than the root, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the target value is greater than the root, search in the right subtree
        return searchBST(root.right, val);

//            if( root.val == val)
//                return root;
//            if ( root.val > val)
//                    searchBST(root.left, val);
//            return searchBST(root.right, val);
    }
}

