import java.util.*;
import java.io.*;




class Solution {
    public int maxArea(int[] height) {
        
        int area = 0;
        
        int index1 = 0;
        int index2 = height.length - 1;
          
        while(index1 < index2){
         if(height[index1]<= height[index2]) {
             if(((index2-index1)*height[index1]) > area){
                 area = ((index2-index1)*height[index1]);
             }
             
                index1++;
         }
        else {
            if (((index2-index1)*height[index2]) > area ){
            area = ((index2-index1)*height[index2]);
            }
             index2--;
             }
            
         }
        return area;
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] height = stringToIntegerArray(line);
            
            int ret = new Solution().maxArea(height);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}