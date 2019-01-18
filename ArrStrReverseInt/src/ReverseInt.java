
public class ReverseInt {
	
	public static int reverseInt(int x) {
		
		int num = x;
		int result = 0;
        while(num != 0) {
            int temp = num % 10;
            int newResult = result * 10 + temp;
            
            if((newResult - temp) / 10 != result)
                return 0;
            
            result = newResult;
            num = num / 10;
        }
        
        return result;
    }

	public static void main(String[] args) {
		int num = 123;
		
		System.out.println("reverse of number " + num + " is " + reverseInt(num));

	}

}
