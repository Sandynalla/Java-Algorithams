package stacksUsingLL;

public class StacksUsingLL<T> {

     Node head; // the first node

    // nest class to define linkedlist node
    public class Node {
        int value;
        Node next;
    }

    public StacksUsingLL() {
        head = null;
    }

    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public int pop() throws LinkedListEmptyException {
        if (head == null) {
            throw new LinkedListEmptyException();
        }
        int value = head.value;
        head = head.next;
        return value;
    }

    // Add value to the beginning of the list for demonstrating behaviour of stack
    public void push(int value) {
        Node oldHead = head;
        head = new Node();
        head.value = value;
        head.next = oldHead;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public int peek() {
        return head.value;
    }

    public static void main(String args[])
    {
        StacksUsingLL lls=new StacksUsingLL();
        lls.push(20);
        lls.push(50);
        lls.push(80);
        lls.push(40);
        lls.push(60);
        lls.push(75);
        System.out.println("Element removed from LinkedList: "+lls.pop());
        System.out.println("Element removed from LinkedList: "+lls.pop());
        lls.push(10);
        System.out.println("Element removed from LinkedList: "+lls.pop());
        lls.printList();
        System.out.println("Element at the top is " + lls.peek());
    }

}

/**
 *
 * Exception to indicate that LinkedList is empty.
 */

class LinkedListEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LinkedListEmptyException() {
        super();
    }

    public LinkedListEmptyException(String message) {
        super(message);
    }
}

