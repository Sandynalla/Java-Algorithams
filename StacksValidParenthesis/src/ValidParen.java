import java.util.*;
import java.util.Stack;

public class ValidParen {

    public static boolean validparen(String str) {
        if(str.length() == 0) return true;

        Stack<Character> stack = new Stack();
        Set<Character> set = new HashSet();
        set.add('(');
        set.add('{');
        set.add('[');

        for(int i=0; i< str.length(); i++) {
            if(set.contains(str.charAt(i))) {
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']') {
                if(stack.empty())
                    return false;
                if(stack.peek() == '(') {
                    if(str.charAt(i) != ')') {
                        return false;
                    }
                    stack.pop();
                }
                else if(stack.peek() == '{') {
                    if(str.charAt(i) != '}') {
                        return false;
                    }
                    stack.pop();
                }
                else if(stack.peek() == '[') {
                    if(str.charAt(i) != ']') {
                        return false;
                    }
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(String.format(
                "Has matching parens %s? : %s", "(abcd)", validparen("(abcd)")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}", validparen("{{{{}}")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{{}}})", validparen("{{{{}}})")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}}()", validparen("{{{}}}()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{{}}]()", validparen("{{{}}]()")));
        System.out.println(String.format(
                "Has matching parens %s? : %s", "{{}}([]){}{}{}{}{[[[[]]]]}",
                validparen("{{}}([]){}{}{}{}{[[[[]]]]}")));
    }
}
