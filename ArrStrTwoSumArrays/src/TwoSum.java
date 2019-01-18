import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for (int i = 0; i < nums.length; i++) {
	    	 if(map.containsKey(target - nums[i])) {
	                result[1] = i;
	                result[0] = map.get(target - nums[i]);
	                return result;
	            }
	            
	            map.put(nums[i], i);
	    }

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {11, 2, 15, 7};
		int target = 9;
		
		int[] result = twoSum(nums, target);
		 System.out.print("[");
			for(int i=0; i<result.length;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.print("]");

	}

}
