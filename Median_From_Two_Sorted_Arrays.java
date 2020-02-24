import java.util.*;
import java.io.*;
import java.text.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        
        if(total%2 == 0){
            int index1 = 0, index2 = 0;
            double previous =0,next = 0;
            
            for(int i = 0 ; i <= (total/2); i++){ 
                if(index1 < nums1.length || index2 < nums2.length){
                if(index2 == (nums2.length)){
                    previous = next;
                    next = nums1[index1];
                    index1++;
                   
                }
                     else if( index1 == (nums1.length)){
                    previous = next;
                    next = nums2[index2];
                    index2++;
                    }
                    else if( nums1[index1] <=nums2[index2]){
                    previous = next;
                    next = nums1[index1];
                    index1++;
                        
                    }
                    else if( nums2[index2] <=nums1[index1] ){
                    previous = next;
                    next = nums2[index2];
                    index2++;

                }

                }
            
        }
            return (previous+next)/2;
        }
        else{
             int index1 = 0, index2 = 0;
           double median =0;
            for(int i = 0; i<=(total-1)/2;i++){
             if(index1 < nums1.length || index2 < nums2.length){
                if(index2 == (nums2.length)){
                    
                    median = nums1[index1];
                    index1++;
                   
                }
                     else if( index1 == (nums1.length)){
                    
                    median = nums2[index2];
                    index2++;
                    }
                    else if( nums1[index1] <=nums2[index2]){
                    
                    median = nums1[index1];
                    index1++;
                        
                    }
                    else if( nums2[index2] <=nums1[index1] ){
                    
                    median = nums2[index2];
                    index2++;

                }

                }
                
           
            }
            return median;
            
        }
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
    
    public static String doubleToString(double input) {
        return new DecimalFormat("0.00000").format(input);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] nums2 = stringToIntegerArray(line);
            
            double ret = new Solution().findMedianSortedArrays(nums1, nums2);
            
            String out = doubleToString(ret);
            
            System.out.print(out);
        }
    }
}