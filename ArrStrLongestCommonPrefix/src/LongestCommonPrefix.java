
public class LongestCommonPrefix {
	
	public static String longestCPrefix(String[] str) {
		
		if(str == null || str.length == 0) return "";
		
		String pre = str[0];
	
		int i = 1;
        while(i < str.length) {
            while(str[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
		
		System.out.println("Longest Common Prefix " + pre);
		return pre;
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        if (strs.length==1) return strs[0];
        int i =2;
        String str = lcp(strs[0],strs[1]);
        while(i<strs.length){
            str = lcp(str,strs[i]);
            i++;
        }
       return str;
   }
   
   private static String lcp(String str1, String str2){
       if (str1.indexOf(str2) ==0) return str2;
       if (str2.indexOf(str1) ==0) return str1;
       int index =0;
       while ((str1.charAt(index)==str2.charAt(index))&&(index<str1.length())&&(index<str2.length())){
           index++;
       }
       if (index==0)return "";
       return str1.substring(0,index);
   }
	
	
	public static void main(String[] args) {
		
		String[] str = {"flow", "florida", "flute"};
		
		longestCPrefix(str);
		
		longestCommonPrefix(str);
		
	}

}
