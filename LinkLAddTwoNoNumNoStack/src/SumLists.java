public class SumLists {

        Node head;

        public static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node sumLists(Node head1, Node head2) {

            if(head1 == null ) return head2;
            if(head2 == null) return head1;

            Node curr1 = head1, curr2 = head2;
            Node result = new Node(0);

            Node resultPtr = result;
            int sum = 0;
            while(curr1 != null || curr2 != null) {
                sum = sum/10;

                if(curr1 != null) {
                    sum = sum + curr1.data;
                    curr1 = curr1.next;
                }

                if(curr2 != null) {
                    sum = sum + curr2.data;
                    curr2 = curr2.next;
                }

                resultPtr.next = new Node( sum % 10);
                resultPtr = resultPtr.next;
            }
         if(sum / 10 == 1) {
             resultPtr.next = new Node(1);
         }
         return result.next;
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

            SumLists list = new SumLists();

            list.head = new Node(1);
            list.head.next = new Node(1);
            list.head.next.next = new Node(9);

            SumLists list1 = new SumLists();

            list1.head = new Node(8);
            list1.head.next = new Node(7);
            list1.head.next.next = new Node(2);

            Node newVal = sumLists(list.head, list1.head);

            printll(newVal);

        }
}
