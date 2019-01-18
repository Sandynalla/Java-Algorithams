public class OddEvenLL {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node oddEvenLL(Node head) {
        if(head == null) return head;

        Node oddHead = head;
        Node evenHead = head.next;

        Node evenPtr = evenHead;

        while(evenPtr != null && evenPtr.next != null) {
            oddHead.next = oddHead.next.next;
            evenPtr.next = evenPtr.next.next;
            oddHead = oddHead.next;
            evenPtr = evenPtr.next;
        }

        oddHead.next = evenHead;
        return head;
    }

    public void printll() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr =curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        OddEvenLL list = new OddEvenLL();

        list.head = new Node(1);
        list.head.next = new Node(4);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(9);
        list.head.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next = new Node(3);

        oddEvenLL(list.head);

        list.printll();

    }


}
