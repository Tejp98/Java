// Question : Maximum Width of Binary Tree


// Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

// The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

// Example 1:

// Input: 

//            1
//          /   \
//         3     2
//        / \     \  
//       5   3     9 

// Output: 4
// Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
// Example 2:

// Input: 

//           1
//          /  
//         3    
//        / \       
//       5   3     

// Output: 2
// Explanation: The maximum width existing in the third level with the length 2 (5,3).
// Example 3:

// Input: 

//           1
//          / \
//         3   2 
//        /        
//       5      

// Output: 2
// Explanation: The maximum width existing in the second level with the length 2 (3,2).
// Example 4:

// Input: 

//           1
//          / \
//         3   2
//        /     \  
//       5       9 
//      /         \
//     6           7
// Output: 8
// Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


// Note: Answer will in the range of 32-bit signed integer.


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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        HashMap<Integer, Integer> minMap = new HashMap<>();
        HashMap<Integer, Integer> maxMap = new HashMap<>();
        dfs(minMap, maxMap, root, 0, 0);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<maxMap.size();i++) {
            if(!maxMap.containsKey(i) || !minMap.containsKey(i)) continue;
            max = Math.max(max, maxMap.get(i) - minMap.get(i));

        }
        return max+1;
    }

    private void dfs(HashMap<Integer, Integer> minMap,
                     HashMap<Integer, Integer> maxMap,
                     TreeNode node,
                     int layer, int index) {
        if(node == null){
            return;
        }
        
        if(!minMap.containsKey(layer)){
            minMap.put(layer, index);
        }
        
        if(!maxMap.containsKey(layer)
                || maxMap.get(layer)<index) {
            maxMap.put(layer, index);
        }

        if(node.left != null) {
            dfs(minMap, maxMap, node.left, layer+1, index*2);

        }
        
        if(node.right != null) {
            dfs(minMap, maxMap, node.right, layer+1, index*2+1);

        }
    }
}