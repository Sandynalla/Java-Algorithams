public class LongestSubstring {
	
	public static int longestSubstring1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        String bucket = s.charAt(0) + "";
        int res = 0;
//start from second character
        for (int i = 1; i < s.length(); i++) {
//if this is new char, append to string bucket
           if (!bucket.contains(s.charAt(i) + "")) {
               bucket += s.charAt(i) + "";
//remove the chars from index 0 to index of duplicate char if bucketalready has it, and add this char to the bucket.
           } else {
               int index = bucket.indexOf(s.charAt(i));
               bucket = bucket.substring(index + 1);
               bucket += s.charAt(i) + "";
           }
            res = Math.max(res, bucket.length());
        }
        return res;
    }
	

	public static void main(String[] args) {
		String str = "abcabcbb";
		
		System.out.println("Longest substring " + longestSubstring1(str));

	}

}
