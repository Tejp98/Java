
// Question : Invert Binary Tree

// Invert a binary tree.

// Example:

// Input:

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// Output:

//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
// Trivia:
// This problem was inspired by this original tweet by Max Howell:

// Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.


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
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if( root == null){
            return root;
        }
        
        recursion(root);
        return root;   
    }
    public void recursion(TreeNode root){
        if(root.left == null && root.right == null){
            return;
        }
        else if(root.left == null){
            root.left = root.right;
            root.right = null;
            recursion(root.left);
        }
        else if(root.right == null){
            root.right = root.left;
            root.left = null;
            recursion(root.right);
        }
        else{
           TreeNode temporary = root.left;
            root.left = root.right;
            root.right = temporary;
            recursion(root.left);
            recursion(root.right); 
        }
        return;
    }
}