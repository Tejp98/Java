// Question : Flatten a Multilevel Doubly Linked List

// You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.

// Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.

 

// Example 1:

// Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
// Output: [1,2,3,7,8,11,12,9,10,4,5,6]
// Explanation:

// The multilevel linked list in the input is as follows:



// After flattening the multilevel linked list it becomes:


// Example 2:

// Input: head = [1,2,null,3]
// Output: [1,3,2]
// Explanation:

// The input multilevel linked list is as follows:

//   1---2---NULL
//   |
//   3---NULL
// Example 3:

// Input: head = []
// Output: []
 

// How multilevel linked list is represented in test case:

// We use the multilevel linked list from Example 1 above:

//  1---2---3---4---5---6--NULL
//          |
//          7---8---9---10--NULL
//              |
//              11--12--NULL
// The serialization of each level is as follows:

// [1,2,3,4,5,6,null]
// [7,8,9,10,null]
// [11,12,null]
// To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:

// [1,2,3,4,5,6,null]
// [null,null,7,8,9,10,null]
// [null,11,12,null]
// Merging the serialization of each level and removing trailing nulls we obtain:

// [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 

// Constraints:

// Number of Nodes will not exceed 1000.
// 1 <= Node.val <= 10^5


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


//First Solution



/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    public Node flatten(Node head) {
        
       
        
        recursion(head);

        
        return head;
        
    }
    public void recursion(Node current){
        
        
        if(current == null){
            return;
        }
        
        if(current.child != null){
            
            recursion(current.child);
            Node temporary = current.next;
            current.next = current.child;
            current.next.prev = current;
            current.child = null;
            
            if(temporary != null){
                while(current.next != null){
                    current = current.next;
                }
                current.next = temporary;
                current.next.prev = current;
            }
           
        }
        
        recursion(current.next);
        
   
    }
}


//Second Solution



class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                if (cur.next != null) {
                    stack.push(cur.next);
                }
                
                cur.next = cur.child;
                if (cur.next != null) {
                    cur.next.prev = cur;
                }
                cur.child = null;
            } 
            else if (cur.next == null && !stack.isEmpty()) {
                cur.next = stack.pop();
                if (cur.next != null) {
                    cur.next.prev = cur;
                }
            }
            
            cur = cur.next;
        }
        
        return head;
    }
}