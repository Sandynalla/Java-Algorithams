
public class StrCompression {
	
	public static String compress(String str) {
		
		String newStr = "";
		//int compressedLength = 0;
		int consecutive = 0;
		
		for(int i = 0; i<str.length(); i++) {
			consecutive++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newStr += "" + str.charAt(i) + consecutive;
				consecutive = 0;
			}
		}
		
		return str.length() == newStr.length() ? str : newStr;
	}
	
	public static String compressSB(String str) {
		StringBuilder sb = new StringBuilder();
		int consecutive = 0;
		
		for(int i = 0; i<str.length(); i++) {
			consecutive++;
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i));
				sb.append(consecutive);
				consecutive = 0;
			}
		}	
		return str.length() == sb.toString().length() ? str : sb.toString();
	}

	public static void main(String[] args) {
		String str = "aaabbbccaacbbbddd";
		
		System.out.println(compress(str));
		System.out.println(compressSB(str));
		

	}

}
