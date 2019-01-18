
public class OneAway {
	
	public static boolean oneAway(String a, String b) {
		if(a.length() == b.length()) {
			return oneEditAway(a, b);
		} else if(a.length() + 1 == b.length()) {
			return oneAdd(a, b);
		} else if(a.length() - 1 == b.length()) {
			return oneAdd(b, a);
		} 
		return false;
	}
	
	public static boolean oneEditAway(String a, String b) {
		boolean diff = false;
		
		for(int i=0; i<a.length();i++) {
			if(a.charAt(i) != b.charAt(i)) {
				if(diff) {
					return false;
				}
				diff = true;
			}
		}
		return true;
	}
	
	public static boolean oneAdd(String a, String b) {
		int i=0;
		int j=0;
		
		while(i < a.length() && j < b.length()) {
			if(a.charAt(i) != b.charAt(j)) {
				if(i != j) {
					return false;
				}
				j++;
			} else {
				i++;
				j++;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "pale";
		String b = "bale";
		
		String d = "ple";
		
		boolean isOneaway = oneAway(a, b);
		boolean isOneaway2 = oneAway(a, d);
		
		System.out.println(a + ' ' + b + ": " + isOneaway);
		System.out.println(a + ' ' + d + ": " + isOneaway2);
		

	}

}
