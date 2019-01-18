
public class PalindromNum {
	
	public static boolean intPalindrome(int num) {
		
		if(num < 0) return false;
		int n = num;
		int revNum= 0;
		
		while(n > 0) {
			int temp = n%10;
			revNum = (revNum * 10) + temp;
			n = n/10;
		}
		
		return revNum == num;
	}

	public static void main(String[] args) {
		
		int numb = 12321;
		
		System.out.println("Is numb - 12321 a palindrome? " + intPalindrome(numb));

	}

}
