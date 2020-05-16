// Question:  Odd Even Linked List

// Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

// You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

// Example 1:

// Input: 1->2->3->4->5->NULL
// Output: 1->3->5->2->4->NULL
// Example 2:

// Input: 2->1->3->5->6->4->7->NULL
// Output: 2->3->6->7->1->5->4->NULL
// Note:

// The relative order inside both the even and odd groups should remain as it was in the input.
// The first node is considered odd, the second node even and so on ...




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */




//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public ListNode oddEvenList(ListNode head) {
       
        if(head == null || head.next == null){
            return head;
        }
        ListNode resultHead = new ListNode(head.val);
        ListNode headParser = head.next;
        ListNode parser = resultHead;
        ListNode even = new ListNode(headParser.val, null);
        ListNode evenParser = even;
        
        headParser = headParser.next;

        int count = 2;
           
                while(headParser != null){
                if(count%2 == 1){
                   evenParser.next = new ListNode(headParser.val, null);
                    evenParser = evenParser.next;
                    count++;
                    headParser  = headParser.next;
                }
                else{
                   parser.next = new ListNode(headParser.val, null);
                    parser = parser.next;
                    headParser =headParser.next;
                    count++;
                }
            }
       parser.next = even;
            return resultHead;
    }
}