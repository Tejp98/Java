// Question : Course Schedule II


// There are a total of n courses you have to take, labeled from 0 to n-1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

// There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

// Example 1:

// Input: 2, [[1,0]] 
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
//              course 0. So the correct course order is [0,1] .
// Example 2:

// Input: 4, [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,1,2,3] or [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both     
//              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
//              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
// Note:

// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.


//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.

//First Solution

import java.util.*;
import java.lang.*;
import java.io.*;


class Solution{

    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adj = new LinkedList[numCourses];
        
        for(int i = 0; i < numCourses; ++i){
            adj[i] = new LinkedList<Integer>();
        }
        
        for(int[] courses: prerequisites){
            adj[courses[1]].add(courses[0]);
        }
        
        List<Integer> s = new LinkedList();
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; ++i){
            if(visited[i] == 0 && dfs(i, adj, s, visited)){ 
                return new int[0];
            }
        }
        
        Collections.reverse(s);
        
        int [] result = new int[numCourses];
        
        
        for(int i=0;i<numCourses;i++){
           result[i] =  s.get(i);
        }
        return result;
    }
    
    public boolean dfs(int u, List<Integer>[] adj, List<Integer> s, int[] visited){
        visited[u] = 1;
        for(int v : adj[u]){
            if(visited[v] == 1) {
                return true;
            }
            if(visited[v] == 0 && dfs(v, adj, s, visited)) {
                return true;
            }
        }
        visited[u] = 2;
        s.add(u);
        return false;
    }
}

//Second Solution


//This Solution would work if there are no cycles in the prerequisites

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList();
        
        for(int i=0;i<numCourses;i++){
            result.add(i);
        }
        
        
         for(int j=0;j<numCourses;j++){
             boolean check = true;
             for(int i=0;i<prerequisites.length;i++){
            int pre = prerequisites[i][1];
             int post = prerequisites[i][0];
             int start = result.indexOf(pre);
             int end =result.indexOf(post);;
             
             if(start>end){
                 check = false;
                 
                 int temporary = result.get(start);
                 result.set(start, result.get(end));
                 result.set(end, temporary);
                
             }
             
             
            
        }
             if(check){
                 break;
             }
        }
        
        
        for(int i=0;i<prerequisites.length;i++){
            int pre = prerequisites[i][1];
             int post = prerequisites[i][0];
             int start = result.indexOf(pre);
             int end =result.indexOf(post);;
             
                 if(start>end){
                     return new int[0];
                 }
            
            }
        
         int [] tem = new int[numCourses];
        
        
        for(int i=0;i<numCourses;i++){
           tem[i] =  result.get(i);
        }
        
        
        return tem;
    }
}
