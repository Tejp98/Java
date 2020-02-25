import java.util.*;

class Pivot{

	 static void pivot_sort(int[] input, int index){
		int pivot = input[index];
		int start_of_array = 0;
		int end_of_array = input.length - 1;

		for(int i = 0; i<input.length; i++){
			if(input[i]<= pivot){
				input[start_of_array] = input[i];
				start_of_array++;
			}
			else if(input[i] > pivot){
				input[end_of_array] = input[i];
				end_of_array--;
			}


		}

		for(int j = 0; j<input.length; j++){
			System.out.println(input[j]);
		}



	}







	public static void main(String args[]){


		Scanner console = new Scanner(System.in);
		System.out.println("Enter the number of elements you want in array");
		int total = console.nextInt();
		int[] input = new int[total];


		for(int i = 0; i<total; i++){
			input[i] = console.nextInt();

		}


		System.out.println("Enter the index of the element that is to be used as pivot");
		int index = console.nextInt();


		pivot_sort(input,index);
	}
}