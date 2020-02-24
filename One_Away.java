import java.util.*;

class One_Away{
	public static void main(String args[]){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter first String");
		String input1 = console.nextLine();
		System.out.println("Enter Second String");
		String input2 = console.nextLine();

		System.out.println("One_Away:"+ CheckUsingBrute(input1,input2));



	}
//More modular program can be made by dividing the following function into different function to check for one_edit, one_replace.
	 static boolean CheckUsingBrute(String input1, String input2){
		
		if(input1.length()==input2.length()){
			boolean check = false;
			for(int i=0; i<input1.length(); i++){
				if(input1.charAt(i) != input2.charAt(i) && check ==true){
					return false;
				}
				else if(input1.charAt(i) != input2.charAt(i) && check == false){
					check = true;
				}
			}
			return true;
		}
		else if(input1.length()-input2.length() == 1){
			int index1 = 0;
			int index2 = 0;
			while(index2 < input2.length() && index1 < input1.length()){
				if(input1.charAt(index1) != input2.charAt(index2)){
					if(index1 != index2){
						return false;
					}
					index1++;
				}
				else{
					index1++;
					index2++;
				}
				
			}
		return true;
		}
		else if(input2.length()-input1.length() == 1){
			int index1 = 0;
			int index2 = 0;
			while(index2 < input2.length() && index1 < input1.length()){
				if(input1.charAt(index1) != input2.charAt(index2)){
					if(index1 != index2){
						return false;
					}
					index2++;
				}

				else{
					index1++;
					index2++;
				}
				
			}
			return true;
		}
		else{
			return false;
		}
	} 

}