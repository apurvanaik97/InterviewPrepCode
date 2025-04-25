package Leetcode.BinaryTree;

import Leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBT {
    public static void main(String[] args) {
        MinDepthOfBT minDepthOfBT = new MinDepthOfBT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(minDepthOfBT.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode current = queue.poll();
            if(current.left == null && current.right == null){
                return depth;
            }
            for(int i =0 ; i < size; i++){
                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            depth++;
        }
        return depth;
    }
}

