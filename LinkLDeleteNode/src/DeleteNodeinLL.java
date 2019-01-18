public class DeleteNodeinLL<T> {
    Node<T> head = null;
    Node<T> current = null;

    DeleteNodeinLL(T[] data) {
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

    //Delete single Nodes based on User Input
    public void deleteNode(T data ) {

        if(data == null || head == null) return;

        Node<T> curr = head;
        Node<T> prev = null;

        while(curr != null) {

            if(curr.getData() == data) {
                break;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        prev.next = curr.next;
        //curr.next = curr.next.next;

    }


    //Delete all data Nodes that are matching param value.
    public Node deleteNodeNew(T data) {

        if(data == null || head == null) return null;

        Node curr = head;
        Node prev = null;

        while(curr != null) {

            if(curr.getData() == data) {
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

        Integer[] num = {1, 3, 3, 4, 7, 5, 5, 6};

        DeleteNodeinLL<Integer> linkList = new DeleteNodeinLL<Integer>(num);

        linkList.printLinkList();

        linkList.deleteNode(3);

        linkList.printLinkList();

        linkList.deleteNodeNew(5);

        linkList.printLinkList();


    }
}