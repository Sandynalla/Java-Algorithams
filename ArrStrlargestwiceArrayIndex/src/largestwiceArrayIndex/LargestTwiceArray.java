package largestwiceArrayIndex;

//Largest Number At Least Twice of Others

public class LargestTwiceArray {
	
	public int dominantIndex(int[] nums) {
		
		int firstMax = 0, secondMax =0, firstMaxIndex = 0;
        
		if(nums.length==1) return 0;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>firstMax){
            	secondMax = firstMax;
                firstMax = nums[i];
                firstMaxIndex = i;
            }
            else if (nums[i] > secondMax && nums[i] != firstMax && i != firstMaxIndex)
            {
            	secondMax =nums[i];
            }
        }
        
        System.out.println("Value of firstMax is " + firstMax + " and index of firstMax is " + firstMaxIndex);

        
        System.out.println("Value of SecondMax is " + secondMax);

        
        return (2*secondMax <= firstMax || secondMax == 0) ? firstMaxIndex : -1;
        
    }

	public static void main(String[] args) {
		int[] arr = {1,0,0,0};
		int[] arr2 = {0, 1};
		
		
		int[] arr1 = {3, 6, 1, 0};
		
		LargestTwiceArray val = new LargestTwiceArray();
		
		LargestTwiceArray val1 = new LargestTwiceArray();
		
		LargestTwiceArray val2 = new LargestTwiceArray();
		
		System.out.println("The double index value is " + val.dominantIndex(arr));
		System.out.println("The double index value is " + val1.dominantIndex(arr1));
		System.out.println("The double value is " + val2.dominantIndex(arr2));
	}
}
