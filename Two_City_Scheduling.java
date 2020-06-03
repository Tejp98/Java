// Question : Two City Scheduling



// There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

// Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

// Example 1:

// Input: [[10,20],[30,200],[400,50],[30,20]]
// Output: 110
// Explanation: 
// The first person goes to city A for a cost of 10.
// The second person goes to city A for a cost of 30.
// The third person goes to city B for a cost of 50.
// The fourth person goes to city B for a cost of 20.

// The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 

// Note:

// 1 <= costs.length <= 100
// It is guaranteed that costs.length is even.
// 1 <= costs[i][0], costs[i][1] <= 1000


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1]) - (o2[0] - o2[1]));
        int result = 0, i = 0, j = costs.length - 1;
        while(i < j) {
            result += costs[i][0];
            result += costs[j][1];
            i++;
            j--;
        }
        return result;
    }
}