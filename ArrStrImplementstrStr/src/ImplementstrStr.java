
public class ImplementstrStr {
	
	public int strStr(String a, String b) {
		
		int length = a.length() - b.length();
		
		int i=0;
		while(i<=length) {
			if(b.equals(a.substring(i, i+b.length()))) {
				return i;
			} else {
				i++;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String a = "hello";
		String b = "ll";
		
		ImplementstrStr test = new ImplementstrStr();
		
		System.out.println(test.strStr(a, b));
		
		

	}

}
