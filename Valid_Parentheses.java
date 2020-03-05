import java.util.*;
import java.lang.*;



// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Note that an empty string is also considered valid.

// Example 1:

// Input: "()"
// Output: true
// Example 2:

// Input: "()[]{}"
// Output: true
// Example 3:

// Input: "(]"
// Output: false
// Example 4:

// Input: "([)]"
// Output: false
// Example 5:

// Input: "{[]}"
// Output: true



class Solution {
     boolean isValid(String s) {
     
        if(s.length() == 0){
            return true;
        }
        char[] values = s.toCharArray();
        Stack<Character> stack = new Stack<>();  
        for(int i = 0 ; i < values.length ; i++){
            if(values[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
            else if(values[i] == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
            else if(values[i] == '}'){
                if(stack.isEmpty() || stack.peek() != '{'){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(values[i]);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
 class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            boolean ret = new Solution().isValid(s);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}