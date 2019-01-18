import java.util.Stack;

public class AddTwoNumbersLL {

    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null) {
            s1.push(l1.data);
            l1 = l1.next;
        }

        while(l2 != null) {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int sum = 0;
        Node list = new Node(0);
        while(!s1.empty() || !s2.empty()) {
            if(!s1.empty()) sum = sum+s1.pop();
            if(!s2.empty()) sum = sum+s2.pop();
            list.data = sum % 10;
            Node temp = new Node(0);
            temp.next = list;
            list = temp;
            sum = sum/10;
        }

        return list.data == 0 ? list.next : list;
    }


    public static void printll(Node node) {
        Node curr = node;

        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        AddTwoNumbersLL list = new AddTwoNumbersLL();

        list.head = new Node(1);
        list.head.next = new Node(1);
        list.head.next.next = new Node(9);

        AddTwoNumbersLL list1 = new AddTwoNumbersLL();

        list1.head = new Node(8);
        list1.head.next = new Node(7);
        list1.head.next.next = new Node(2);

        Node newVal = addTwoNumbers(list.head, list1.head);

        printll(newVal);


    }
}