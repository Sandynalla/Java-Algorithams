public class MergeSortedLL {

    Node head;

    public static Node mergeSortedLL(Node l1, Node l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        Node mergeHead = new Node(0);
        Node ptr = mergeHead;

        while(l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }

        if(l1 != null)
            ptr.next = l1;

        if(l2 != null)
            ptr.next = l2;

        return mergeHead.next;
    }



    public static void printLinkList(Node d) {
        Node curr = d;
        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {


        MergeSortedLL list = new MergeSortedLL();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(6);
        list.head.next.next.next.next = new Node(7);



        MergeSortedLL list1 = new MergeSortedLL();

        list1.head = new Node(2);
        list1.head.next = new Node(3);
        list1.head.next.next = new Node(6);
        list1.head.next.next.next = new Node(18);

        printLinkList(list.head);
        printLinkList(list1.head);

        printLinkList(mergeSortedLL(list.head, list1.head));


    }
}
