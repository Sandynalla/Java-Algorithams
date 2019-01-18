public class SwapLL {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node swapPairs(Node head) {
        Node newNode = new Node(0);

        newNode.next = head;

        Node slow;
        Node fast = newNode;

        while(fast.next != null && fast.next.next != null) {

            Node prev = fast;

            fast = fast.next;

            slow = fast;

            fast = fast.next;

            Node after = fast.next;
            slow.next = after;
            fast.next = slow;
            prev.next = fast;

            fast = slow;
        }

        printll(newNode.next);

        return newNode.next;
    }

    public static void printll(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SwapLL list = new SwapLL();

        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

        swapPairs(list.head);

    }
}
