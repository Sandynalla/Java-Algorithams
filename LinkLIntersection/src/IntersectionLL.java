public class IntersectionLL {

    Node head;


    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int printcountll(Node head) {

        Node curr = head;
        int count = 0;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            count++;
            curr = curr.next;
        }
        System.out.println();
        return count;

    }

    public static Node findIntersection(Node headA, Node headB) {
        int lenA = printcountll(headA), lenB = printcountll(headB);

        while(lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        if(headA == null || headB == null) {
            System.out.println("No Intersection found");
        }
        //printcountll(headA);
        return headA;
    }

    public static void main(String[] args) {

        IntersectionLL list1 = new IntersectionLL();

        list1.head = new Node(1);
        list1.head.next = new Node(4);
        list1.head.next.next = new Node (2);
        list1.head.next.next.next = new Node(6);
        list1.head.next.next.next.next = new Node(9);
        list1.head.next.next.next.next.next = new Node(3);

        IntersectionLL list2 = new IntersectionLL();

        list2.head = new Node(8);
        list2.head.next = new Node(7);
        list2.head.next.next = new Node (5);
        //list2.head.next.next = list1.head.next.next.next;

        //printcountll(list1.head);
        //printcountll(list2.head);

        Node intersection = findIntersection(list1.head, list2.head);

        printcountll(intersection);


    }
}
