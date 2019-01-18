
public class StringRotation {
	
	public static boolean isRotation(String s1, String s2) {
		int len = s1.length();
		
		if(len == s2.length() && len > 0) {
			String s1s1 = s1+s1;
			if(s1s1.indexOf(s2) != -1) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		
		for(String[] pair: pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean rotation = isRotation(word1, word2);
			System.out.println(word1 + " " + word2 + ": " + rotation);
		}

	}
}
