
//  Question : Online Stock Span

// Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

// The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

// For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

 

// Example 1:

// Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
// Output: [null,1,1,1,2,1,4,6]
// Explanation: 
// First, S = StockSpanner() is initialized.  Then:
// S.next(100) is called and returns 1,
// S.next(80) is called and returns 1,
// S.next(60) is called and returns 1,
// S.next(70) is called and returns 2,
// S.next(60) is called and returns 1,
// S.next(75) is called and returns 4,
// S.next(85) is called and returns 6.

// Note that (for example) S.next(75) returned 4, because the last 4 prices
// (including today's price of 75) were less than or equal to today's price.
 

// Note:

// Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
// There will be at most 10000 calls to StockSpanner.next per test case.
// There will be at most 150000 calls to StockSpanner.next across all test cases.
// The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.

//  PLease note that only a function that gets all the values of the questions and returns answer is written not the whole implementation.



import java.util.*;
import java.lang.*;
import java.io.*;




class StockSpanner {
    ArrayList<Integer> prices;
    ArrayList<Integer> value;
    public StockSpanner() {
       prices = new ArrayList<Integer>();
       value = new ArrayList<Integer>();
    }
    
    public int next(int price) {
        
        
        if(prices.size()==0){
            prices.add(price);
            value.add(1);
            return 1;
        }
        else{
        if( prices.get(prices.size()-1) > price ){
           
            prices.add(price);
            value.add(1);
            
            return 1;
        }
        else if(prices.get(prices.size()-1) == price ){
            prices.add(price);
            value.add(value.get(value.size()-1)+1);
            return value.get(value.size()-1);
        }
        else{
            
            int i = prices.size()-1;
            prices.add(price);
            int count =1;
            while(i>=0){
                if(prices.get(i) < price){
                    count = count + value.get(i);
                        i = i - value.get(i);
                    
                }
                else if(prices.get(i) == price){
                    count = count  + value.get(i);
                    value.add(count);
                    break;
                }
                else{
                    value.add(count);
                   break;
                }
                
                if(i<0){
                    value.add(count);
                    
                }
            
        }
            
          return count;
        }
        }
        
         
        }
    
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */