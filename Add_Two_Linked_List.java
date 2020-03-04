import java.util.*;
import java.lang.*;


//Alternate Solution if the linked list are not very long
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode ab = l1;
        ListNode b = l2;
        int index = 0;
        int counter = 0;
        while( l1.next != null){
            counter++;
            l1=l1.next;
        }
        long number1 = 0;
        
        for(int i= 0; i<=counter; i++){
            number1 = (long)(ab.val * Math.pow(10,i)) + number1;
            ab = ab.next;
        }
        
        int counter1 = 0;
        while( l2.next != null){
            counter1++;
            l2 = l2.next;
            
        }
        long number2 = 0;
        
        for(int i= 0; i<=counter1; i++){
            number2 = (long)(b.val * Math.pow(10,i)) + number2;
            if(b.next != null)
            b = b.next;
        }
         long number3 = number1 + number2;
        System.out.println(number3);
        String s = new  StringBuilder(Double.toString(number3)).reverse().toString();
        char[] array = s.toCharArray();
        ListNode output = new ListNode(Character.getNumericValue(array[0]));
        output.next = null;
        for(int i = 1; i < array.length;i++){
          
        ListNode new_node = new ListNode(Character.getNumericValue(array[i]));
            ListNode last = output;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;  
        }
         return output;
    }
}

//Solution which works for all linked list

class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
    ListNode p = l1, q = l2, current = head;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        current.next = new ListNode(sum % 10);
        current = current.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        current.next = new ListNode(carry);
    }
    return head.next;
    }
}



 class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
    
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
    
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);
            
            ListNode ret = new Solution().addTwoNumbers(l1, l2);
            
            String out = listNodeToString(ret);
            
            System.out.print(out);
        }
    }
}