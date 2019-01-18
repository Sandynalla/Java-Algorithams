public class KthToLastEle {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node kthToLastElement(Node head, int k) {

        if(head == null) return head;

        Node start = new Node(0);

        start.next = head;

        Node slow = start, fast = start;

        for(int i =0; i<=k; i++) {
            if(fast == null) return start;
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        printll(start.next);

        return start.next;

    }

    public static void printll(Node head) {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr =curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        KthToLastEle list = new KthToLastEle();

        list.head = new Node(1);
        list.head.next = new Node(4);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(9);
        list.head.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next = new Node(3);

        //printll(list.head);

        kthToLastElement(list.head, 3);

    }
}
