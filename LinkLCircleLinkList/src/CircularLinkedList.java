public class CircularLinkedList {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static boolean circularLL(Node t) {

        if(t == null) return false;

        Node runner = t;
        Node walker = t;

        while(runner != null && walker != null) {
            walker = walker.next;
            runner = runner.next.next;

            if(runner == walker) return true;
        }

        return false;
    }

    public static void main(String[] args) {


        CircularLinkedList list = new CircularLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = list.head.next;

        System.out.println("Is this a Circular LinkedList? " + circularLL(list.head));
    }

}
