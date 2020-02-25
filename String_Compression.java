import java.util.*;

class String_Compression{
	public static void main(String args[]){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the String");
		String input = console.nextLine();

		System.out.println(Compressed(input));

	}

	static String Compressed(String input){

		int index1 = 0;
		int index2 = 1;
		StringBuilder compressed_string = new StringBuilder();
		int counter = 1;
		while(index1<input.length() && index2<input.length()){
			if(input.charAt(index1) == input.charAt(index2)){
				counter++;
				index2++;
				if(index2 == input.length()){
					compressed_string.append(input.charAt(index1));

					compressed_string.append(counter);
				}
			}
			else{
				compressed_string.append(input.charAt(index1));
				compressed_string.append(counter);
				counter = 1;
				index1 = index2;
				index2++;
			}
		}
		return compressed_string.toString();
	}
}