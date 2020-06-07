
// Question : Queue Reconstruction by Height


// Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

// Note:
// The number of people is less than 1,100.

 
// Example

// Input:
// [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

// Output:
// [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 




//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;



class Solution {
    public int[][] reconstructQueue(int[][] people) {
       
        if(people.length<=1){
            return people;
        }
        
       List<int[]> result = new ArrayList();
       
        Arrays.sort(people, (a,b) -> {
            return (a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        });
    
        for(int[] i : people){
            result.add(i[1],i);
        }
        

        
       return result.toArray(new int[people.length][2]); 
    }
}


//Complex Solution



class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int counter =-1;
        if(people.length<=1){
            return people;
        }
        int[][] result = new int[people.length][2];
    
        Arrays.sort(people, new Comparator<int[]>(){
             public int compare(int[] o1, int[] o2){
                       return(Integer.valueOf(o1[0]).compareTo(o2[0]));
         }});
        
        
        if(people[0][0]==0 && people[0][1]== 0){
            result[0]=people[0];
            for(int i=1;i<people.length;i++){
            
            for(int j=1;j<result.length;j++){        
                
                if(people[i][1] == 0){
                    
                    for(int k=1;k<people.length;k++){
                        if(result[k][0] == 0 && result[k][1] == 0){
                            result[k] = people[i];
                            break;
                        }
                    }
                    break;
                }
                
                
                if(people[i][0] <= result[j][0]){
                    counter++;
                }
                else if(result[j][0] == 0 && result[j][1]==0){
                    counter++;
                } 
            

                if(people[i][1] == counter){
                    result[j] = people[i];
                            break;
                        }
                    
                }
            
            counter=-1;
       
        }
        }
        else{
            for(int i=0;i<people.length;i++){
            
            for(int j=0;j<result.length;j++){        
                
                if(people[i][1] == 0){
                    
                    for(int k=0;k<people.length;k++){
                        if(result[k][0] == 0 && result[k][1] == 0){
                            result[k] = people[i];
                            break;
                        }
                    }
                    break;
                }
                
                
                if(people[i][0] <= result[j][0]){
                    counter++;
                }
                else if(result[j][0] == 0 && result[j][1]==0){
                    counter++;
                } 
            

                if(people[i][1] == counter){
                    result[j] = people[i];
                            break;
                        }
                    
                }
            
            counter=-1;
       
        }
        }
        

        
       return result; 
    }
}