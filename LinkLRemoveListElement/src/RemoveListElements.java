public class RemoveListElements {

    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node removeListElements(Node t, int val) {

        if(t == null) return t;

        Node curr = t;
        Node newList = new Node(0);
        newList.next = t;
        Node prev = newList;

        while(curr != null) {

            if(curr.data == val && curr.next != null) {
                prev.next = curr.next;
                curr = curr.next;

            } else if(curr.data == val && curr.next == null) {
                prev.next = null;
                curr = curr.next;
            }
            else {
                prev = curr;
                curr = curr.next;
            }

        }

        System.out.println(prev.data);
        Node test = newList.next;
        while(test != null) {
            System.out.print(" " + test.data);
            test = test.next;
        }
        return newList.next;
    }

    public Node removeElementLL(int data) {

        if(head == null) return null;

        Node curr = head;
        Node prev = null;

        while(curr != null) {

            if(curr.data == data) {
                Node next = curr.next;
                prev.next = next;
                curr = curr.next;

            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return prev;

    }

    public void printLinkList() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {


        RemoveListElements list = new RemoveListElements();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(6);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);

        //removeListElements(list.head, 6);

        list.removeElementLL(6);
        list.printLinkList();


    }

}
