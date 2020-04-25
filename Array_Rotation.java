
// A left rotation operation on an array shifts each of the array's elements  unit to the left.
 // For example, if  left rotations are performed on array , then the array would become 

// Given an array  of  integers and a number, , perform  left rotations on the array. 
// Return the updated array to be printed as a single line of space-separated integers

// Function Description

// Complete the function rotLeft in the editor below
 // It should return the resulting array of integers

// rotLeft has the following parameter(s):

// An array of integers 
// An integer , the number of rotations
// Input Format

// The first line contains two space-separated integers  and , the size of  and the number of left rotations you must perform.
// The second line contains  space-separated integers

// Constraints
// Output Format
// Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

// Sample Input

// 5 4
// 1 2 3 4 5
// Sample Output

// 5 1 2 3 4
// Explanation

// When we perform  left rotations, the array undergoes the following sequence of changes:



import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Array_Rotation {

    // Complete the rotLeft function below
    static int[] rotLeft(int[] a, int d) {

            int[] result = new int[a.length];

            for(int i =0;i<a.length;i++){
                result[i]= a[(i+d)%a.length];
            }

            return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
