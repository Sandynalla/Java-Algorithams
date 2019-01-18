//Easy Java Solution O(n)
//0. Check the size of the array if its 0, return -1.
//1. initialize the variables leftSum, rightSum to 0 
//2. loop through array and assign sum of all items to rightSum 
//3. Looping back on array again to
//a. substract the i element from rightSum 
//b. compare rightSum with Left sum, if same return index value i 
//c. add i element to leftSum
//5. If nothing above is satisfied, return -1.

public class PivotIndexArray {
	
	public int pivotIndex(int[] nums) {
		
		int rightSum = 0, leftSum = 0;
		
		if(nums.length == 0) return -1;
		
		for(int items: nums) {
			rightSum += items;
		}
		
		System.out.println("RightSum value is " + rightSum);
		
		for(int i=0; i<nums.length; i++) {
			rightSum -= nums[i];
			if(rightSum == leftSum) {	
				return i;
			}
			leftSum += nums[i];
		}
		
		return -1;
	}
	

	public static void main(String[] args) {
		int[] arr = {1,7,3,6,5,6};
		
		PivotIndexArray val = new PivotIndexArray();
		
		System.out.println("The pivot index value is " + val.pivotIndex(arr));

	}

}
