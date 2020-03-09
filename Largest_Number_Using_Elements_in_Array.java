import java.util.*;
import java.lang.*;
import java.io.*;





// Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return the result in the form of a string.
// Example: 3 30 34 5 9
// 		54 546 548 60

// Output:
// 9534330
// 6054854654


class Largest_Number {
	public static void main (String[] args) {
		//code
		Scanner console = new Scanner(System.in);
		
		System.out.println("Enter the elements");
		String input = console.nextLine();
		
		char[] input_array = input.toCharArray();
		Arrays.sort(input_array);
		String output = new String();
		for(int i=input_array.length-1 ; i>=0;i--){
		    output = output + input_array[i];
		}
		
		System.out.println(output);
		
	}
}