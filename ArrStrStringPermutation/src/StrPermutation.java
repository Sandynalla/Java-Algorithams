//Find out if god is a string permutation to dog.
public class StrPermutation {

	public static void main(String[] args) {
		
		String str1 = "god";
		String str2 = "dog";
		System.out.println(strPermu(str1, str2));
		System.out.println(strPermu1(str1, str2));
		
		String str3 = "blow";
		String str4 = "slow";
		System.out.println(strPermu(str3, str4));
		System.out.println(strPermu1(str3, str4));

	}
	
	//Using inbuilt Sort method.
	public static boolean strPermu(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		return sort(str1).equals(sort(str2));
	}
	
	public static String sort(String val) {
		char[] charArr = val.toCharArray();
		java.util.Arrays.sort(charArr);
		return new String(charArr);
	}
	
	//Checking with Identical Character counts;
	public static boolean strPermu1(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		
		int[] charCount = new int[128];
		for(int i=0; i<str1.length();i++) {
			charCount[str1.charAt(i)]++;	
		}
		
		for(int j=0; j<str2.length(); j++) {
			charCount[str2.charAt(j)]--;
			if(charCount[str2.charAt(j)] < 0) {
				return false;
			}
		}
		return true;
	}
	

}
