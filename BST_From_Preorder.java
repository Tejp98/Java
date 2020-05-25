
// Question : Construct Binary Search Tree from Preorder Traversal

// Return the root node of a binary search tree that matches the given preorder traversal.

// (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

// It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

// Example 1:

// Input: [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]

 

// Constraints:

// 1 <= preorder.length <= 100
// 1 <= preorder[i] <= 10^8
// The values of preorder are distinct.



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

//Two Solutions


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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder.length==0){
            return null;
        }
        else if(preorder.length == 1){
            TreeNode root = new TreeNode(preorder[0]);
            return root;
        }
        
        TreeNode root = new TreeNode();
         int value = recursion(preorder ,0, root, -1, 100000000 );
        return root;
    }
    public  int recursion(int[] preorder, int position, TreeNode current, int lower, int higher){
         if(current.val == 0){
             current.val = (preorder[position]);
             position++;
             position = recursion(preorder, position, current, lower, higher);
         }
        if(position >= preorder.length || preorder[position] < lower || preorder[position] > higher){
            return position;
        }
       
        if(preorder[position] > current.val){
            current.right = new TreeNode(preorder[position]);
            position++;
            
            position = recursion(preorder, position, current.right, current.val-1, higher);
            lower = current.val-1;
            current = current.right;
            
        }
        else{
            current.left = new TreeNode(preorder[position]);
            position++;
            position = recursion(preorder, position, current.left, lower, current.val-1);
             higher = current.val-1;
            current = current.left;
           
        }
        if(position < preorder.length){
            
            position = recursion(preorder,position,current, lower, higher);
        }
        return position;
    } 
}

// Smaller and more Understandable Solution:



class Solution {
    int preIndex =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,Integer.MAX_VALUE); 
    }

    TreeNode constructBST(int[] preOrder,int val){
        if (preIndex==preOrder.length || val<preOrder[preIndex])
            return null;
        TreeNode root=new TreeNode(preOrder[preIndex++]);
        root.left=constructBST(preOrder,root.val);
        root.right=constructBST(preOrder,val);
        return root;
    }
}