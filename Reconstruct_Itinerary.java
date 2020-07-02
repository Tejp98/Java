// Question : Reconstruct Itinerary


// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

// Note:

// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.
// One must use all the tickets once and only once.
// Example 1:

// Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// Example 2:

// Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
// Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//              But it is larger in lexical order.



//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList();
        
        Collections.sort(tickets, new Comparator<List<String>>() {    
        @Override
        public int compare(List<String> o1, List<String> o2) {
            return o1.get(1).compareTo(o2.get(1));
        }               
        });
        result.add("JFK");
        result.addAll(recursion("JFK", tickets)) ;
        
        return result;
    }
    
    public List<String> recursion(String from, List<List<String>> tickets ){
        
        if(tickets.size() == 1){
            List<String> result = new ArrayList();
            result.add(tickets.get(0).get(1));
            return result;
        }
        
        List<String> result = new ArrayList();
        
        int index =tickets.size();
        
            for(int i =0;i<index;i++){
                List<String> temporary = tickets.get(i);
                 if(temporary.get(0).equals(from)){
                     
                     
                     tickets.remove(i);
                     
                     List<String> fleeting = recursion(temporary.get(1), tickets);
                     
                     if(fleeting == null){
                         tickets.add(i, temporary);
                         continue;
                     }
                     
                     else{
                         
                        result.add(temporary.get(1));
                         result.addAll(fleeting);
                         return result;
                     }
                 }
               
        }
    
        return null;
    }
}