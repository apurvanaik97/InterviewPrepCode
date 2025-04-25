package Leetcode.Blind75;

import Leetcode.TreeNode;

import java.util.*;

public class RightSideViewTree {
    public static void main(String[] args) {
        RightSideViewTree rsv = new RightSideViewTree();
        //1,2,3,4,null,null,null,5
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        rsv.rightSideView(root);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        traverseTree(root, 0, result);
        return result;
    }

    private void traverseTree(TreeNode root, int level, List<Integer> result) {

        if(root == null)
            return ;

        if(level == result.size())
            result.add(root.val);

        if(root.right!= null){
            traverseTree(root.right, level +1, result);
        }

        if(root.left!= null){
            traverseTree(root.left, level +1, result);
        }

    }
}

