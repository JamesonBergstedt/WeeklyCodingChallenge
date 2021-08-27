import java.math.BigInteger;

//
//Java:
//Create a function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.
//
//Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:
//
//Remove the last digit (this is the "check digit").
//Reverse the number.
//Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
//Add all digits.
//Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
//Examples
//validateCard(1234567890123456) --> false
//
//// Step 1: check digit = 6, num = 123456789012345
//// Step 2: num reversed = 543210987654321
//// Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
//// Step 4: sum = 58
//// Step 5: 10 - 8 = 2 (not equal to 6) --> false
//
//validateCard(1234567890123452) --> true


public class Week1 {

	// Main method
	public static void main(String[] args) {
		long num = 1234567890123452L;
		System.out.println(validateCard(num));
	}
	
	public static boolean validateCard(long num) {
		String s_num = String.valueOf(num);
		int check = s_num.charAt(s_num.length()-1) - '0';
		if(s_num.length() < 14) {
			return false; 
		}
		else {
			// We need to remove the last digit
			s_num = s_num.substring(0, s_num.length()-1);
			StringBuilder sb1 = new StringBuilder();
			sb1.append(s_num);
			s_num = sb1.reverse().toString();
			
			char[] ch = s_num.toCharArray();
			for( int i = 0; i<ch.length; i=i+2) {
				int temp = ch[i] - '0';
				
				temp = temp*2;
				if(temp >= 10) {
					String s_temp = String.valueOf(temp);
					
					int firstDigit = s_temp.charAt(0) - '0';
					int secondDigit = s_temp.charAt(1) - '0';
					ch[i] = (char) ((firstDigit + secondDigit) + '0');
				}
				else {
					ch[i] = (char)(temp + '0');
				}
			}
			
			
			int total = 0;
			for(int i = 0; i<ch.length; i++) {
				total += Character.getNumericValue(ch[i]);
				
			}
			
			String s_total = String.valueOf(total);
			if(10 - Character.getNumericValue(s_total.charAt(s_total.length()-1)) == check) {
				return true;
			}
			else {
				return false;
			}
			
		}
		
	}
}
