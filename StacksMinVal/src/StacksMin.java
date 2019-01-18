public class StacksMin {

    Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int peek() {
        System.out.println("Peeking Stack value: " + head.val);
        return head.val;
    }

    public int getMin() {
        System.out.println("Min Stack value: " + head.min);
        return head.min;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.val);
            temp = temp.next;
        }
        System.out.println();
    }



    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String args[])
    {
        StacksMin lls=new StacksMin();
        lls.push(20);
        lls.push(8);
        lls.push(17);
        lls.push(7);
        lls.push(11);
        lls.getMin();
        lls.pop();
        lls.pop();
        lls.top();
        lls.getMin();
        lls.printList();
        lls.peek();

    }

}
