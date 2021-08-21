package week2.day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declare a String text with the following value
		String text = "Tes12Le79af65";
		// Declare a int variable sum
		int sum = 0;
		char[] character=text.toCharArray();
		// a) Iterate an array over the String
		for(int i=0;i<character.length;i++)
		{
			char charValue=character[i];
			// b) Get each character and check if it is a number using Character.isDigit()
			if(Character.isDigit(charValue))
			{
				// c) Now covert char to int using Character.getNumericValue() and add it to sum
				int a=Character.getNumericValue(charValue);
				sum=sum+a;
		}
		
	}
		// d) Now Print the value
		System.out.println("sum =  "+ sum);
	}

}



