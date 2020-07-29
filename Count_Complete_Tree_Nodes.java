//  Question : Count Complete Tree Nodes


// Given a complete binary tree, count the number of nodes.

// Note:

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Example:

// Input: 
//     1
//    / \
//   2   3
//  / \  /
// 4  5 6

// Output: 6


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;

// First Solution


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

 */
class Solution {
    public int countNodes(TreeNode root) {
        if(root != null){
            return recursion(root)+1;
        }
        return 0;
    }
    public int recursion(TreeNode root){
        int count = 0;
        if(root.left != null){
            count = count +1+ recursion(root.left);
        }
        if(root.right != null){
            count = count + 1+ recursion(root.right);
        }
        return count;
    }
}


// Second Solution


class Solution {
    public int countNodes(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        TreeNode left =root,right =root;
        int countLeft=0, countRight =0;
        while(left != null){
            countLeft++;
            left = left.left;
        }
        while(right != null){
            countRight++;
            right = right.right;
        }
        // System.out.println(countLeft+"left"+countRight+"right");
        if(countLeft==countRight){
            return ((int)(Math.pow(2,countLeft)))-1;
        }
        else{
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
}