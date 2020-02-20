import java.util.*;

class Palindrome{
	public static void main(String args[]){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the String");
		String input = console.nextLine();

		System.out.println("Palindrome:"+ check_palindrome(input));

	}
	static boolean check_palindrome(String input){
		
			
			
			char[] input_array = input.toCharArray();
			int[] check = new int[input_array.length+100];//Trying to figure out why ArrayIndexOutofBound exception occurs, thats why added 100.
			for(int i=0; i < input_array.length; i++){
				check[input_array[i]] = check[input_array[i]] +1;

			}
			if(input.length()%2 ==0){
			for(int i : check){
				if(check[i]%2!=0){
					return false;
				
				

			}

		}
		return true;
}
		else{
			int counter= 0;
			for(int i=0; i <check.length;i++){
				if(check[i]%2!=0){
					counter++;
				}}
				if(counter ==1){return true;}
				else {return false;}
			}

		
	}
}
