import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishNotation {

    public static int evalRPN(String[] arr) {

        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(String s: arr) {
            if(s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.equals("-")) {
                stack.push(stack.pop() - stack.pop());
            }
            else if(s.equals("/")) {
                stack.push(stack.pop() / stack.pop());
            }
            else {
                stack.push(Integer.valueOf(s));
            }
        }

        return stack.peek();
    }


    public static void main(String[] args) {

        String[] arr = {"2", "1", "+", "3", "*"};

        System.out.println("Reverse Polish Notation: " + evalRPN(arr));
    }
}
