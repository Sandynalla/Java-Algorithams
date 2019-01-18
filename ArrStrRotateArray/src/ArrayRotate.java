
public class ArrayRotate {
	
	public static void arrayRotateIterr(int[] arr, int num) {
		if(num > arr.length) {
			num = num%arr.length;
		}
		int[] result = new int[arr.length];
		 
	    for(int i=0; i < num; i++){
	        result[i] = arr[arr.length-num+i];
	    }
	 
	    int j=0;
	    for(int i=num; i<arr.length; i++){
	        result[i] = arr[j];
	        j++;
	    }
	 
	    System.arraycopy( result, 0, arr, 0, arr.length );
	}
	
	public static void arrayRotateRecur(int[] arr, int num) {
		if (arr == null || arr.length==0 || num < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		if(num > arr.length){
			num = num %arr.length;
		}
		
		int a = arr.length - num; 
		 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
	}
	
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		
		int num = 2;
		
		arrayRotateIterr(arr, num);
		
		System.out.println("Value of Arr after Array Rotate is ");
		for(int i: arr) {
			System.out.print(i);
		}
		System.out.println();
		
		int[] newArr = {1,2,3,4,5,6,7};
		
		int newNum = 3;
		
		arrayRotateRecur(newArr, newNum);
		
		System.out.println("Value of Arr after Array Rotate is ");
		for(int i: newArr) {
			System.out.print(i);
		}

	}

}
