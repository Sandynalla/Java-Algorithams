public class PalindromeLL {

    static Node head;


    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean palindromLL() {

        Node current = head;
        printll(current);
        Node revll = head;
        Node reverse = reverse(revll);

        printll(current);
        printll(reverse);

        while(current != null && reverse != null) {

            if(current.data != reverse.data) {
                return false;
            }
             else {
                 current = current.next;
                reverse = reverse.next;
            }
        }
        return true;

    }

    public Node reverse(Node ele) {
        Node curr = ele;
        Node prev = null;

        while(curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=next;
        }
        return prev;
    }

    public void printll(Node val) {
        Node curr = val;

        while(curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr =curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        PalindromeLL list = new PalindromeLL();

        list.head = new Node(1);
        list.head.next = new Node(1);
        list.head.next.next = new Node (2);
        list.head.next.next.next = new Node(1);
        //list.head.next.next.next.next = new Node(1);

        System.out.println("Is the given LinkedList a Palindrome? " + list.palindromLL());

    }
}
