


// Question:  Find the Town Judge

// In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

// If the town judge exists, then:

// The town judge trusts nobody.
// Everybody (except for the town judge) trusts the town judge.
// There is exactly one person that satisfies properties 1 and 2.
// You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

// If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

 

// Example 1:

// Input: N = 2, trust = [[1,2]]
// Output: 2
// Example 2:

// Input: N = 3, trust = [[1,3],[2,3]]
// Output: 3
// Example 3:

// Input: N = 3, trust = [[1,3],[2,3],[3,1]]
// Output: -1
// Example 4:

// Input: N = 3, trust = [[1,2],[2,3]]
// Output: -1
// Example 5:

// Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
// Output: 3
 

// Note:

// 1 <= N <= 1000
// trust.length <= 10000
// trust[i] are all different
// trust[i][0] != trust[i][1]
// 1 <= trust[i][0], trust[i][1] <= N




// import java.util.HashSet;
// import java.util.Set;
import java.util.*;
import java.lang.*;
import java.io.*;




class Solution {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> people = new HashSet<Integer>(); 
        for(int i=0;i<N;i++){
            people.add(i+1);
        }
        
        for(int i =0 ; i<trust.length;i++){
            people.remove(trust[i][0]);
        }
        if(people.size()>0){
            for(int x : people){
                Set<Integer> random = new HashSet<Integer>();
                System.out.println(x);
                for(int k =0;k<N;k++){
                    if(k+1 == x){
                        continue;
                    }
                    else{
                    random.add(k+1);
                    }
                }
                for(int j = 0 ; j<trust.length;j++){
                    if(trust[j][1] == x){
                        random.remove(trust[j][0]);
                    }
                }
                if(random.size()==0){
                    return x;
                }
            }
                
        }
        else{
            return -1;
        }
       return -1; 
    }
}