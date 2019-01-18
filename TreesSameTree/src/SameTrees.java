public class SameTrees {

    public static boolean sameTree(Node node1, Node node2) {

        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;

        if(node1.data == node2.data) {
            return (sameTree(node1.getLeftChild(), node2.getLeftChild()) && sameTree(node1.getRightChild(), node2.getRightChild()));
        }
        else {
            return false;
        }
    }


    public static class Node<T> {

        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;

        }

        public T getData() {
            return this.data;
        }

        public Node<T> getLeftChild() {
            return this.left;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.left = leftChild;
        }

        public Node<T> getRightChild() {
            return this.right;
        }

        public void setRigthChild(Node<T> rightChild) {
            this.right = rightChild;
        }
    }

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(10);
        Node<Integer> b = new Node<>(15);
        Node<Integer> c = new Node<>(30);


        a.setLeftChild(b);
        a.setRigthChild(c);

        Node<Integer> d = new Node<>(10);
        Node<Integer> e = new Node<>(15);
        Node<Integer> f = new Node<>(30);

        d.setLeftChild(e);
        d.setRigthChild(f);



        System.out.println("Passed in trees are same or not? " + sameTree(a, d));
    }
}
