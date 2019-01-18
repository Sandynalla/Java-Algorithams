import java.util.ArrayList;

public class Urlify {

	public static void main(String[] args) {
		
		//first way
		String str1 = "Mr John Doe";
		
		//System.out.println("URLIFIED String " + urlifyString(str1));
		
		//second way
		String str2 = "Mr John Doe    ";
		char[] arr = str2.toCharArray();
		int trueLength = lastCharOfArray(arr) + 1;
		System.out.println(trueLength);
		System.out.println(urlifyString(arr, trueLength));
		
		System.out.println("URLify with other method " + urlifyReplace(str1));
		System.out.println("URLify with new method " + urlifywithStringBuilder(str1));

	}
	
	public static String urlifyReplace(String str) {
		return str.replace(" ", "%20");
	}
	
	public static String urlifywithStringBuilder(String str) {
		String[] words = str.split(" ");
		StringBuilder sentence = new StringBuilder(words[0]);
		
		for(int i=0; i<words.length;i++) {
			sentence.append("%20");
			sentence.append(words[i]);
		}
		return sentence.toString();
		
	}
	
	
	//Using String Array to loop and add %20s in the spaces.
	public static String urlifyString(String str) {
		
	 String urlifiedStr = null;	
	 String[] strArr = str.split(" ");
	 
	 for(int i=0; i< strArr.length; i++) {
		 if(urlifiedStr == null) {
			 urlifiedStr = strArr[i] + "%20";
		 } else if(i+1 == strArr.length){
		 urlifiedStr = urlifiedStr + strArr[i];
		 } else {
			 urlifiedStr = urlifiedStr + strArr[i] + "%20";
		 }
	 }
		return urlifiedStr;
	}
	
	//Using Traditional way 
	public static int lastCharOfArray(char[] arr) {
		
		for(int i=arr.length-1; i>=0; i--) {
			if(arr[i] != ' ') {
				return i;
			}
		}
		return -1;
	}
	
	public static String urlifyString(char[] arr, int trueLength) {
		System.out.println(trueLength);
		int space = 0, index, i=0;
		for(i=0; i<trueLength; i++) {
			if(arr[i] == ' ') 
				space++;
		}
		index = trueLength + space * 2;
		if(trueLength < arr.length) arr[trueLength] = '\0';
		for(i = trueLength -1; i >= 0; i--) {
			if(arr[i] == ' ') {
				arr[index-1] = '0';
				arr[index-2] = '2';
				arr[index-3] = '%';
				index = index-3;
			} else {
				arr[index-1] = arr[i];
				index--;
			}
		}
		StringBuilder finalStr = new StringBuilder(arr.length);
		for(char c: arr) {
			if(c == 0) break;
			finalStr.append(c);
		}
		return finalStr.toString();
	}
}
