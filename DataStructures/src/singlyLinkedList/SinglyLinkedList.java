package singlyLinkedList;

//This is a Singly LinkedList Implementation.
public class SinglyLinkedList {

    Node head = null;
    Node current = null;

    SinglyLinkedList(int[] data) {
        for (int i = 0; i < data.length; i++) {
            addNode(data[i]);
        }
    }

    //Add Nodes to LinkedList
    public Node addNode(int data) {
        Node newNode = new Node();

        newNode.data = data;
        if (head == null) {
            head = newNode;
        } else {
            current.next = newNode;
        }
        current = newNode;
        return newNode;
    }

    public Node addFirst(int data) {
        Node newNode = new Node();

        newNode.data = data;
        if(head == null) {
            head = newNode;
        }
        else {

            newNode.next = head;
            head = newNode;
        }
        return newNode;
    }

    public Node addLast(Node head, int data) {
        Node newNode = new Node();

        newNode.data = data;

        Node addLast = head;

        while(addLast.next != null) {
            addLast = addLast.next;
        }

        addLast.next = newNode;
        System.out.println(addLast.data);

        return addLast;
    }

    public Node addAfter(int nodeValue, int data) {

        Node newNode = new Node();

        newNode.data = data;

        Node current = head;

        while(current != null) {
            if(current.data == nodeValue) {
                Node temp = current.next;
                current.next = newNode;
                newNode.next = temp;
                System.out.println(current.next.data);
                return current;
            } else if(current.next == null) {
                return null;
            }
            else {
                current = current.next;
            }
        }

        return null;
    }

    //Insert at nth position of the linkedlist
    public void insertNth(int n, int data) {
        if (n > countNodes()) {
            return;
        }

        if (n == 0) {
            Node curr = head;
            head.data = data;
            head.next = curr;
        } else {
            int i = 0;
            Node curr = head;
            while (i < n - 1) {
                curr = curr.next;
                i++;
            }
            Node newNode = new Node();
            newNode.data = data;
            Node val = curr.next;
            curr.next = newNode;
            newNode.next = val;
        }

    }

    //Get Head of LinkedList
    public Node getHead() {
        return head;
    }

    //Get Current value of LinkedList
    public Node getCurrent() {
        return current;
    }

    //Print LinkedList
    public void printLinkList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    //Count LinkedList
    public int countNodes() {
        Node curr = head;
        int ct = 0;

        if (head == null) {
            return 0;
        }
        while (curr != null) {
            ct++;
            curr = curr.next;
        }
        return ct;
    }

    //Delete LinkedList
    public void deleteLinkList() {
        head = null;
    }

    //Reverse LinkedList
    public void reverseList() {
        Node curr = head;
        Node prev = null;

        if (curr == null || curr.next == null) {
            return;
        }

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //Remove first Element in LinkedList
    public Node removeFirstElement() {
        if (head == null || head.next == null) {
            return head;
        }
        Node element = head;
        head = head.next;

        return element;
    }

    //Remove Last Element in LinkedList
    public Node removeLastElement() {
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;

        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Prev Value " + prev.data);

        prev.next = null;
        current = prev;
        return curr;
    }

    public Node removeNthElement(int data) {
        if(head == null) {
            System.out.println("Linked List is empty");
            return head;
        }

        if(head.data == data) {
             head = head.next;
        }
            Node current = head;
            Node prev = null;

            while (current != null) {
                if (current.data == data) {
                    System.out.println(prev.data);
                    prev.next = current.next;
                    break;
                } else {
                    prev = current;
                    current = current.next;
                }
        }
        return prev;
    }




    public class Node {

        public int data;
        public Node next;

        Node() {
        }

//        public void setData(T data) {
//            this.data = data;
//        }
//
//        public T getData() {
//            return this.data;
//        }
    }

    public static void main(String[] args) {

        int[] num = {1, 3, 4, 6};

        SinglyLinkedList linkList = new SinglyLinkedList(num);

        linkList.printLinkList();

        System.out.println("Get current ->" + linkList.getCurrent().data + " Get Head ->" + linkList.getHead().data + " Count Nodes ->" + linkList.countNodes());

        linkList.reverseList();

        linkList.printLinkList();

        System.out.println("Remove First Element ->" + linkList.removeFirstElement().data);

        linkList.printLinkList();

        System.out.println("Remove Last Element ->" + linkList.removeLastElement().data);

        linkList.printLinkList();

        linkList.insertNth(1, 5);

        linkList.printLinkList();

        linkList.addFirst(8);

        linkList.printLinkList();

        linkList.addLast(linkList.head, 10);

        linkList.printLinkList();

        linkList.addAfter(5, 7);

        linkList.printLinkList();

        linkList.removeNthElement(7);

        linkList.printLinkList();

    }


}
