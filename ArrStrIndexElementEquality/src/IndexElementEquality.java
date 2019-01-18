
class IndexElementEquality {

    static int indexEqualsValueSearch(int[] arr) {
        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = start + ((end - start)/2);

            if((arr[mid] - mid) == 0) {
                return mid;
            } else if (arr[mid] > mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        //int[] arr = {-8, 0, 2, 5};
        //int[] arr = {0};
        int[] arr = {-6, -5, -4,-1, 1, 3, 5, 7};

        System.out.println(indexEqualsValueSearch(arr));
    }

    /*
    function indexEqualsValueSearch(nums) {
  let s = 0
  let e = nums.length;
  let result = Infinity
  let mid = null

  while (s <= e && s < result) {
    mid = Math.floor((s+e)/2)

    if (nums[mid] < mid) {
      s = mid+1
    } else {
      if (nums[mid] === mid) {
        result = Math.min(result, mid)
      }
      e = mid-1
    }
  }

  return result === Infinity ? -1 : result
}
    */


}