import java.util.*;
import java.lang.*;


class Solution {
    public int longestValidParentheses(String s) {
         int count = 0;
        int start = -1;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) =='(') count++;
            else if(s.charAt(i) ==')') count--;
            
            if(count < 0){
                count = 0;
                start = i;
                
            }else if(count == 0){
                if(i - start > max) max = i - start;
                
            }
            
        }
          
            count = 0;
            start = s.length();
            
           for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) ==')') count++;
            else if(s.charAt(i) =='(') count--;
            
            if(count < 0){
                count = 0;
                start = i;
                
            }else if(count == 0){
                if(start - i > max) max =  start - i;
                
            }
        }
             
        return max;
    }
}
 class MainClass {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            
            int ret = new Solution().longestValidParentheses(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}