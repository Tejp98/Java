// Question : Search in a Binary Search Tree


// Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

// For example, 

// Given the tree:
//         4
//        / \
//       2   7
//      / \
//     1   3

// And the value to search: 2
// You should return this subtree:

//       2     
//      / \   
//     1   3
// In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

// Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.

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

 //  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root.val == val ){
            return root;
        }
        else if(root.val > val){
            if(root.left != null){
               return searchBST(root.left, val);
            }
            else{
                return null;
            }
        }
        else{
            if(root.right != null){
              return  searchBST(root.right, val);
            }
            else{
                return null;
            }
        }
        
    }
}