
public class UniqueStr {

	public static void main(String[] args) {
		  String value = "Task"; //expect true
	        System.out.println(uniqueStrChars(value));
	       String otherVal = "Testt"; //expects false 
	       System.out.println(uniqueStrChars(otherVal));
	       
	       System.out.println(uniqueStrChars1(value));
	       System.out.println(uniqueStrChars1(otherVal));
	      
	 
	}
	
	//brute force approach
	 public static boolean uniqueStrChars(String val) {
		 if(val.length() > 128) return false;
	        for(int i=0; i<val.length();i++) {
	            for(int j=i+1; j<val.length();j++) {
	                if(val.charAt(i) == val.charAt(j)) {
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	 
	 
	 //using extra DataStructure
	 public static boolean uniqueStrChars1(String val) {
		 
		 if(val.length() > 128) return false;
		 
		 boolean[] strChar = new boolean[128];  //Boolean array that creates 128 characters with value false.
		 for(int i=0; i<val.length();i++) {
			 char newVal = val.charAt(i);
			 if(strChar[newVal]) {
				 return false;
			 }
			 strChar[newVal] = true;
		 }
		 
		 return true;
	 }

}
