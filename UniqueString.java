import java.util.*;

class PMain{
	public static void main(String args[]){

		Scanner input = new Scanner(System.in);

		System.out.println("Enter a String");
		String input1 = input.next();
		boolean abc = CheckUnique1(input1);
		System.out.println( "String is Unique:" + abc);

	}


				//Using For Loop
		  static boolean CheckUnique (String input1){ 

		 	for(int i = 0; i < input1.length()-1; i++) {

		 		for(int j = i+1; j <input1.length(); j++) {
		 		
		 			if(input1.charAt(i)==input1.charAt(i)){
		 				return false;
		 			}

		 		}
		 	}

		 	return true;



		 }

		 static boolean CheckUnique1 (String input1){
		 	if(input1.length() > 128)
		 		return false;
		 	else{
		 		boolean[] char1 = new boolean[128];
		 		for(int i=0; i< input1.length(); i++){
		 			int int_val = input1.charAt(i);
		 			if(char1[int_val] == true){
		 				return false;
		 			}
		 			else {
		 				char1[int_val] = true;
		 			}
		 		}
		 		return true;

		 		}
		 	}

		 

		
}