
public class ReverseStrStack {

	public static void main(String[] args) {
		
		String newStr = "Siddartha";
		
		System.out.println(reverseString(newStr));

	}
	
	public static String reverseString(String str) {
		int strLength = str.length();
		
		StackImpl stackRev = new StackImpl(strLength);
		
		for(int i = 0; i<strLength; i++ ) {
			char ch = str.charAt(i);
			stackRev.push(ch);
		}
		
		String revStr = "";
		
		while(!stackRev.isEmpty()) {
			char ch = stackRev.pop();
			revStr += ch;
		}
		
		return revStr;
	}

}
