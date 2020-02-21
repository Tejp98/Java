import java.util.*;

class Reverse{
	public static void main(String args[]){
		
		System.out.println("Enter a string");
		Scanner console = new Scanner(System.in);
		String input = console.nextLine();
		String reversed = new StringBuilder(input).reverse().toString();
		System.out.println(reversed);
		





		
		StringBuilder reverse = new StringBuilder(input.length()); //Second Method
		for(int i=input.length()-1; i >=0; i--){
			reverse.append(input.charAt(i));

		}

		System.out.println(reverse);
	}
}