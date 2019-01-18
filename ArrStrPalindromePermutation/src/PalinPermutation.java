import java.util.HashMap;

public class PalinPermutation {

	public static void main(String[] args) {

		//String string1 = "Hello There";
		String string2 = "Taco tac";
		//System.out.println(isPalindromePermutable(string1));
		//System.out.println(isPalindromePermutable(string2));
		
		//System.out.println(isPalindPerHash(string1));
		System.out.println(isPalindPerHash(string2));
		
	}
	
	//Algorithm 1
	public static boolean isPalindromePermutable(String str) {
		
		int[] table = frequencyTable(str);
		return palinPerm(table);

	}
	
	public static boolean palinPerm(int[] table) {
		boolean foundOneOdd = false;
		for(int count: table) {
			if(count % 2 == 1) {
				if(foundOneOdd) {
					return false;
				}
				foundOneOdd = true;
			}
		}
		
		return true;
	}
	
	public static int[] frequencyTable(String str) {
		int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1]; //int[26];
		
		for(char c: str.toCharArray()) {
			int x = getCharNumericValue(c);
			if(x != -1) {
				table[x]++;
			}
		}
		return table;
	}
	
	public static int getCharNumericValue(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		
		if(a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
	
	//Algorithm 2 with HashMap
	public static boolean isPalindPerHash(String str) {
		
		String str1 = str.toLowerCase();
		char[] arr = str1.toCharArray();
		HashMap<Character, Integer> hash = new HashMap<>();
		for(int i = 0; i<arr.length;i++) {
			if(arr[i] == ' ') continue;
			hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
		}
		int count = 0;
		for(char ch: hash.keySet()) {
			if(hash.get(ch) % 2 != 0) {
				count++;
			}
			if(count > 1) {
				return false;
			}
		}
		return true;
	}

}
