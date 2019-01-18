public class ReverseLinkedList {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node reverseLL() {

        if(head == null || head.next == null) {
            return head;
        }

        else {
            Node curr = head;
            Node prev = null;

            while(curr != null) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        return head;
    }

    public void displayLL() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {


        ReverseLinkedList llrev = new ReverseLinkedList();

        llrev.head = new Node(3);
        llrev.head.next = new Node (5);
        llrev.head.next.next = new Node(6);
        llrev.head.next.next.next = new Node (8);
        llrev.head.next.next.next.next = new Node (9);

        llrev.displayLL();
        llrev.reverseLL();
        llrev.displayLL();

    }
}

