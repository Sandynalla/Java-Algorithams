public class LinkedListImplementation {
        class Node
        {
            int val;
            Node next;

            public Node(int val)
            {
                this.val = val;
            }
        }

        Node head;
        int length;

    public LinkedListImplementation()
        {
            this.length = 0;
        }

        public int get(int index)
        {
            index++;
            if(index > length)
            {
                return -1;
            }

            Node curr = head;
            while(index-- > 1)
            {
                curr = curr.next;
            }
            System.out.println(curr.val);
            return curr.val;
        }

        public void addAtHead(int val)
        {
            addAtIndex(0, val);
        }

        public void addAtTail(int val)
        {
            addAtIndex(this.length, val);
        }

        public void addAtIndex(int index, int val)
        {
            index++;
            if(index > length + 1)
            {
                return;
            }

            Node node = new Node(val);
            if(index == 1)
            {
                node.next = head;
                head = node;
            }
            else
            {
                Node curr = head;
                while(index > 2)
                {
                    curr = curr.next;
                    index--;
                }

                node.next = curr.next;
                curr.next = node;
            }

            length++;
        }

        public void deleteAtIndex(int index)
        {
            index++;
            if(length == 0 || index > length)
            {
                return;
            }

            if(index == 1)
            {
                head = head.next;
            }
            else
            {
                Node curr = head;
                while(index > 2)
                {
                    curr = curr.next;
                    index--;
                }

                curr.next = curr.next.next;
            }

            length--;
        }

    public void displayLL() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.val + (curr.next != null ? "->" : ""));
            curr = curr.next;
        }
        System.out.println();
    }

        public static void main(String[] args) {

            LinkedListImplementation list = new LinkedListImplementation();

            list.addAtHead(4);
            list.addAtIndex(1, 6);
            list.addAtTail(7);

            list.addAtTail(9);
            list.deleteAtIndex(2);
            list.get(1);

            list.displayLL();


        }
}
