// Question : Binary Tree Zigzag Level Order Traversal


// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]



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
    Map<Integer, List> mapValWithLevel;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }
        
        mapValWithLevel = new HashMap();
        helper(0, root);
        
        int index = 0;
        
        List<List<Integer>> result = new ArrayList();
        while(mapValWithLevel.containsKey(index)){
            if(index%2 == 0){
                result.add(mapValWithLevel.get(index));
            }
            else{
                List<Integer> tem = mapValWithLevel.get(index);
                Collections.reverse(tem);
                
                result.add(tem);
            }
            index++;
        }
        
        return result;
        
    }
    public void helper(int level, TreeNode root){
        if(root != null){
            if(mapValWithLevel.containsKey(level)){
                mapValWithLevel.get(level).add(root.val);
            }
            else{
                List<Integer> temporary = new ArrayList();
                temporary.add(root.val);
                mapValWithLevel.put(level, temporary);
            }
            
        }
        else{
            return;
        }
        
        // if(root.left != null){
            helper(level+1, root.left);
            
        // }
        // if(root.right != null){
            helper(level+1, root.right);
            
        // }
    }
}