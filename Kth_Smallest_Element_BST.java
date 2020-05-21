// Question : Kth Smallest Element in a BST

// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 

// Example 1:

// Input: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// Output: 1
// Example 2:

// Input: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// Output: 3
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

 

// Constraints:

// The number of elements of the BST is between 1 to 10^4.
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

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
    public int kthSmallest(TreeNode root, int k) {
        
        int[] number = new int[2];
        recursion(root, number, k);
        
        return number[1];
    }
    public void recursion(TreeNode tree, int[] number, int k){
       
        if(tree == null){
            return;
        }
         System.out.println(tree.val);
        System.out.println(number[0]);
        recursion(tree.left,number,k);
        if( ++number[0] == k){
            number[1] = tree.val;
            return;
        }
        recursion(tree.right, number,k);
    }
}