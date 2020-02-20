import java.util.*;

class Space{
	public static void main(String args[]){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the string");

		String input = console.nextLine();
		char[] input_array = input.toCharArray();
		StringBuilder output = new StringBuilder();
		for(int i=0; i<input.length();i++){
			
			if(input_array[i] == ' '){
				output.append("%20");
				//System.out.print("%20");
			}
			else{
				output.append(input_array[i]);
				//System.out.print(input.charAt(i));
			}
		}
		
		System.out.println(output.charAt(2));
		System.out.println(output);
	}
}