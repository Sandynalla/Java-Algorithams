import java.util.Arrays;

public class GettingDifferentNumber {

    public static int getDiffNum(int[] arr){
        int n = arr.length;
        if( arr == null || n < 1 ) {
            return 0; // 0 is not in an empty array
        }

        boolean[] foundNum = new boolean[n+1];

        for( int i : arr ) {
            if( i < foundNum.length ) {
                foundNum[i] = true;
            }
        }

        for( int i = 0; i < foundNum.length; i++ ) {
            if( !foundNum[i] ) {
                return i;
            }
        }

        return -1; // array holds more than n+1 unique elements
    }

    //brute force approach

    public static int getDifferentNumber(int[] arr) {

        Arrays.sort(arr);

        if(arr.length == 1) {
            return (arr[0] == 0) ? 1 : 0;
        }

        for(int i=0; i < arr.length; i++) {
            if (i == arr.length-1 && arr[i-1]+1 == arr[i]) {
                return arr[i]+1;
            } else if(arr[i+1] - arr[i] > 1) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {6, 4, 8,9,1,2,3,0};


        System.out.println(getDiffNum(arr));

        System.out.println(getDifferentNumber(arr));


    }

}

