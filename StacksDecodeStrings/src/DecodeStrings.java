import java.util.Stack;

public class DecodeStrings {

    public static String decodeStr(String s) {

        if(s == "")
            return "";

        String res = "";
        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> resStack = new Stack<String>();
        int i = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int c = Character.getNumericValue(s.charAt(i));
                countStack.push(c);
                i++;
            } else if(s.charAt(i) == '[') {
                resStack.push(res);
                res = "";
                i++;
            } else if(s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(resStack.pop());
                int repeat = countStack.pop();
                for(int j=0; j<repeat; j++) {
                    temp.append(res);
                }

                res = temp.toString();
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        String str = "3[a]2[bc]";

        //String str2 = "2[abc]3[cd]ef";

        System.out.println("Decoded value of String is " + decodeStr(str));

        //decodeStr(str2);
    }
}
