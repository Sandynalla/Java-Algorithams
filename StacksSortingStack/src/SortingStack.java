import java.util.Stack;

public class SortingStack {

    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tempStack = new Stack<Integer>();

        while(!input.isEmpty()) {
            int temp = input.pop();

            while(!tempStack.isEmpty() && tempStack.peek() > temp) {
                input.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }

    public static void main(String[] args) {

        Stack<Integer> input = new Stack<Integer>();

        input.add(34);
        input.add(11);
        input.add(21);
        input.add(7);
        input.add(56);
        input.add(14);
        input.add(28);

        System.out.println("Peeking" + input.peek());

        Stack<Integer> tempStack = sortStack(input);

        while(!tempStack.isEmpty()) {
            System.out.print(tempStack.pop() + " ");
        }
    }


}
