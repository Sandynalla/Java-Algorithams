public class PlusOneLL {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node plusOne(Node head) {

        Node newNode = new Node(0);
        newNode.next = head;
        Node i = newNode;
        Node j = newNode;

        while(j.next != null) {
            j = j.next;
            if(j.data != 9) {
                i = j;
            }
        }

        if(j.data != 9) {
            j.data++;
        } else {
            i.data++;
            i=i.next;
            while(i!=null) {
                i.data = 0;
                i = i.next;
            }
        }

        if(newNode.data == 0) {
            return newNode.next;
        }

        return newNode;
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

        PlusOneLL list = new PlusOneLL();

        list.head = new Node(1);
        list.head.next = new Node(1);
        list.head.next.next = new Node(9);

        plusOne(list.head);

        list.printll();

    }

}
