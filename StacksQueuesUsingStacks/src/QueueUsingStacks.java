import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stackNewest;
    Stack<Integer> stackOldest;

    /** Initialize your data structure here. */
    public QueueUsingStacks() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackNewest.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStacks(); //ensure stackOldest has the current elements
        return stackOldest.pop();
    }

    /** Get the front element. */
    public int peek() {
        shiftStacks();
        System.out.println("Peeking top element " + stackOldest.peek());
        return stackOldest.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOldest.isEmpty() && stackNewest.isEmpty();
    }
    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public static void main(String args[])
    {
        /* Create a queue with items 1 2 3*/
        QueueUsingStacks q= new QueueUsingStacks();

        q.push(6);
        q.push(11);
        q.push(9);
        q.push(7);
        q.push(2);
        q.peek();

        /* Dequeue items */
        System.out.print(q.pop()+" ");
        System.out.print(q.pop()+" ");
        System.out.print(q.pop()+" ");
        System.out.print(q.pop()+" ");
        System.out.print(q.pop()+" ");
    }
}
