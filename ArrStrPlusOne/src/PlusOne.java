

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		
		for(int i=length-1;i>=0;i--) {
			if(digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			
			digits[i] =0;
		}
		int[] newArr = new int[length+1];
		newArr[0] = 1;
		return newArr;
	}
	
	public void displayArr(int[] arr) {
		System.out.print("[");
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("]");
		System.out.println();
	}


	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4};
		int[] arr2 = {9,9,9,9};

		int[] arr1 = {3, 6, 1, 0};
		
		PlusOne val = new PlusOne();
		
		int[] newVal = val.plusOne(arr);
		int[] newVal2 = val.plusOne(arr2);
		int[] newVal3 = val.plusOne(arr1);
		
		val.displayArr(newVal);
		val.displayArr(newVal2);
		val.displayArr(newVal3);
		
	}

}
