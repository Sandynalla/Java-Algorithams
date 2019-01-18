public class MiddleOfLinkedList<T> {

    Node<T> head = null;
    Node<T> current = null;

    MiddleOfLinkedList(T[] data) {
        for(int i=0; i<data.length;i++) {
            addNode(data[i]);
        }
    }

    //Add Nodes to LinkedList
    public Node<T> addNode(T data) {
        Node<T> newNode = new Node<T>();

        newNode.setData(data);
        if (head == null) {
            head = newNode;
        } else {
            current.next = newNode;
        }
        current = newNode;
        return newNode;
    }

    //Count LinkedList
    public int countNodes() {
        Node<T> curr = head;
        int ct = 0;

        if(head == null) {
            return 0;
        }
        while(curr != null) {
            ct++;
            curr = curr.next;
        }
        return ct;
    }

    public Node<T> middleOfLinkList() {

        int count = countNodes()/2;

        Node<T> curr = head;
        int i=0;
        while(i<count) {
            curr = curr.next;
            i++;
        }
        return curr;
    }

    //Print LinkedList
    public void printLinkList() {
        Node<T> curr = head;
        while(curr != null) {
            System.out.print(curr.getData() + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }


    //Version 2 with Fast and Slow
    public Node middleLLNode() {
        Node<T> fast = head;
        Node<T> slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }


    public class Node<T> {

        T data;
        Node next;

        Node() {
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }
    }

    public static void main(String[] args) {

        Integer[] num = {1, 3, 4, 8, 5, 7, 6};

        MiddleOfLinkedList<Integer> linkList = new MiddleOfLinkedList<Integer>(num);

        linkList.printLinkList();

        System.out.println("Middle of the Nodes is " + linkList.middleOfLinkList().getData());

        System.out.println("Middle version 2 " + linkList.middleLLNode().getData());



    }
}
