public class PartitionList {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node partition(Node node, int x) {

        Node newNode1 = new Node(0);
        Node newNode2 = new Node(0);

        Node p1 = newNode1, p2 = newNode2;

        while(node != null) {
            if(node.data < x) {
                p1.next = node;
                p1 = p1.next;
            } else {
                p2.next = node;
                p2 = p2.next;
            }
            node = node.next;
        }
        p2.next = null;
        p1.next = newNode2.next;

        return newNode1.next;

    }

    public void displayLL() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void printList(Node head) {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {

        PartitionList list = new PartitionList();

        list.head = new Node(1);
        list.head.next = new Node (3);
        list.head.next.next = new Node (2);
        list.head.next.next.next = new Node (4);
        list.head.next.next.next.next = new Node (7);
        list.head.next.next.next.next.next = new Node (2);
        list.head.next.next.next.next.next.next = new Node (5);


        list.displayLL();

        Node part = partition(list.head, 3);

        printList(part);


    }
}
