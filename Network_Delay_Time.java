// Question : Network Delay Time

// There are N network nodes, labelled 1 to N.

// Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

// Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

 

// Example 1:



// Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
// Output: 2
 

// Note:

// N will be in the range [1, 100].
// K will be in the range [1, N].
// The length of times will be in the range [1, 6000].
// All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;


class Solution {
  
    public int networkDelayTime(int[][] times, int N, int K) {
        
        int[] bellman = new int[N+1];
        Arrays.fill(bellman,99999);
        bellman[K] = 0;
        boolean check = true;
        
        // System.out.println("src"+);
        while(check){
            check = false;
            for(int i =0;i<times.length;i++){
             if((bellman[times[i][0]]+times[i][2])< bellman[times[i][1]]){
                  bellman[times[i][1]] = (bellman[times[i][0]]+times[i][2]);
                 check = true;
                 
             }
                
            }
            
        }
        
        int max=-1;
        for(int i =1;i<bellman.length;i++){
            if(bellman[i] == 99999){
                return -1;
            }
            max =Math.max(max, bellman[i]);
            
        }
        
        
        
        return max;
        
      
    }

}