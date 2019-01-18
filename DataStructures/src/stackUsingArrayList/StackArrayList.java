package stackUsingArrayList;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArrayList<E> {

    private ArrayList<E> stack;

    public StackArrayList() {
        stack = new ArrayList<E>();
    }

    public void push(E item) {
        stack.add(item);
    }

    public E pop() {
        if (!isEmpty())
            return stack.remove(size()-1);
        else
            throw new EmptyStackException();
    }

    public boolean isEmpty() {
        return (stack.size() == 0);
    }

    public E peek() {
        if (!isEmpty()) {
            System.out.println(stack.get(size() - 1));
            return stack.get(size() - 1);
        }
        else
            throw new EmptyStackException();
    }

    public int size() {
        return stack.size();
    }

    public void show() {
        System.out.println("Stacks: ");
        for (E n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("ARRAY SIZE:" + stack.size());
    }

    @Override
    public String toString() {
        return "MyStack [al=" + stack.toString() + "]";
    }

    public static void main(String[] args) {

        StackArrayList<Integer> stack = new StackArrayList<Integer>();

        stack.push(12);
        stack.push(14);
        stack.push(18);
        stack.push(21);

        stack.show();
        stack.pop();
        stack.pop();
        stack.push(21);
        stack.pop();
        stack.show();
        stack.size();
        stack.peek();

    }
}
