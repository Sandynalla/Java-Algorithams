public class LLRemoveDuplicates<T> {

    Node<T> head = null;
    Node<T> current = null;

    LLRemoveDuplicates(T[] data) {
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

    //Remove Duplicates in Sorted List
    public void removeDuplicates() {
        if(head == null || head.next == null) {
                return;
        } else {
            Node<T> curr = head;
            while(curr.next != null ) {
                if(curr.getData() == curr.next.getData()) {
                    curr.next = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
        }
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

        Integer[] num = {1, 3, 3, 4, 5, 5, 6};

        LLRemoveDuplicates<Integer> linkList = new LLRemoveDuplicates<Integer>(num);

        linkList.printLinkList();

        linkList.removeDuplicates();

        linkList.printLinkList();

    }
}
