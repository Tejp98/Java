// Question : Sum Root to Leaf Numbers


// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// Note: A leaf is a node with no children.

// Example:

// Input: [1,2,3]
//     1
//    / \
//   2   3
// Output: 25
// Explanation:
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Therefore, sum = 12 + 13 = 25.
// Example 2:

// Input: [4,9,0,5,1]
//     4
//    / \
//   9   0
//  / \
// 5   1
// Output: 1026
// Explanation:
// The root-to-leaf path 4->9->5 represents the number 495.
// The root-to-leaf path 4->9->1 represents the number 491.
// The root-to-leaf path 4->0 represents the number 40.
// Therefore, sum = 495 + 491 + 40 = 1026.


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
    
    int total =0;
    public int sumNumbers(TreeNode root) {
        if(root ==null){
            return 0;
        }
    
        recursion(root,"");
        return total;
                   
    }
    public void recursion(TreeNode root, String sum){
        
        if(root.left == null && root.right == null){
            total += Integer.parseInt(sum+root.val);
            return;
        }
        if(root.left != null){
            recursion(root.left, sum+root.val);
           
        }
        if(root.right != null){
            recursion(root.right, sum+root.val);
           
        } 
    
    }
}