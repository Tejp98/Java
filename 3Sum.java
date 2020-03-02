
import java.util.*;
import java.io.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
       for(int i = 0; i < nums.length;i++){
if(i > 0 && nums[i] == nums[i -1]){
continue;
}
int left = i+1;
int right = nums.length -1;

        while(left < right){
            int sum = nums[i] + nums[left]+ nums[right];
            if(sum == 0){
                output.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                left++;
                while(left < right && nums[left] == nums[left -1]){
                    left++; 
                }
            }else if(sum > 0){
                right--;
            }else{
                left++;
            }
        }
        
    }
        return output;
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
    
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }
    
    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list: nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }
    
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            List<List<Integer>> ret = new Solution().threeSum(nums);
            
            String out = int2dListToString(ret);
            
            System.out.print(out);
        }
    }
}