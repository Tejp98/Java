// Question : Sum of Left Leaves

// Find the sum of all left leaves in a given binary tree.

// Example:

//     3
//    / \
//   9  20
//     /  \
//    15   7

// There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


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

//First Solution

class Solution {
    int result =0;
    public int sumOfLeftLeaves(TreeNode root) {
       helper(root);
        return result;
    }
    
    public void helper(TreeNode root){
         if(root == null){
            return ;
        }
        
         if(root.left != null){
             sumOfLeftLeaves(root.left);
        }
       if(root.right != null){
           sumOfLeftLeaves(root.right);
       }
        if(root.left ==null){
            return;
        }
       if(root.left.left == null && root.left.right ==null){
           result += root.left.val; 
       }
       
        
    }
}


//Second Solution

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root==null)
        {
            return 0;
        }
        else if(root.left!=null && root.left.left==null&& root.left.right==null)
        {
            return root.left.val+sumOfLeftLeaves(root.right);
        }
        else
        {
            return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
        }
    }
}