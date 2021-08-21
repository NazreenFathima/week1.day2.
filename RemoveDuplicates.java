package week2.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";
		// b Initialize an integer variable as count
		int count = 0;
		// c) Split the String into array and iterate over it
		String[] split = text.split("");
		// d) Initialize another loop to check whether the word is there in the array
		for (int i=0; i<split.length; i++)
		{
			// e) if it is available then increase and count by 1.
			count++;
			for (int j=i+1; j<split.length; j++ )
			{
				if(split[i].equals(split[j]))
				{
					count++;
					
					split[j]="";
				}
			}
			if(count>=1) {
				// g) Displaying the String without duplicate words
				System.out.print(split[i]+" ");
			}
		}
		
		
		// g) Displaying the String without duplicate words

	}

}
