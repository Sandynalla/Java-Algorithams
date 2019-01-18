package stacksDynamicImpl;

public class DynamicStack {

    /* */

    private int top;
    private int capacity;
    private int[] stack;

    public DynamicStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }

    public void push(int data) {
        if (isFull()){
            System.out.println("Stack is full, we are expanding");
            expandArray();      //if array is full then increase its capacity
        }
        top++;
        stack[top] = data;    //insert the data
    }

    public void expandArray() {
        int curr_size = top + 1;
        int[] newStack = new int[curr_size * 2];

        //Instead of for loop, we can use System.arraycopy -  System.arraycopy(stack, 0, newStack, 0, length);
        for(int i=0;i<curr_size;i++){

            newStack[i] = stack[i];
        }
        stack = newStack;              //refer to the new array
        capacity = newStack.length;
    }

    public boolean isFull() {
        if (capacity == top+1)
            return true;
        else
            return false;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            reduceSize();                 //function to check if size can be reduced
            int oldTop = stack[top];
            top--;
            stack[top] = 0;
            return oldTop;
        }
    }

    public void reduceSize() {
        int curr_length = top+1;
        if (curr_length < capacity / 2) {
            int[] new_array = new int[capacity / 2];
            System.arraycopy(stack, 0, new_array, 0, new_array.length);
            stack = new_array;
            capacity = new_array.length;
        }
    }

    public boolean isEmpty() {
        if (top == -1)
            return true;
        else
            return false;
    }

    public void show() {
        System.out.println("Stacks: ");
        for (int n : stack) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("ARRAY SIZE:" + stack.length);
    }


    public void peek() {
        if(isEmpty()) {
            return;
        }
        int data = stack[top];
        System.out.println(data);
    }


    public int size() {
        return top;
    }


    public static void main(String[] args) {
        int capacity = 3;
        DynamicStack stack = new DynamicStack(capacity);

        stack.push(12);
        stack.push(14);
        stack.push(18);
        stack.push(21);

        stack.show();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.show();
        stack.size();
        stack.peek();

    }

}
