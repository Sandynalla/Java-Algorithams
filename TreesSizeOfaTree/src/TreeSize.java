public class TreeSize {

    public static int size(Node node) {
        if(node == null) return 0;

        int left = size(node.getLeftChild());
        int right = size(node.getRightChild());

        return left + right + 1;
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
        Node<Integer> d = new Node<>(3);
        Node<Integer> e = new Node<>(6);
        Node<Integer> f = new Node<>(5);
        Node<Integer> g = new Node<>(2);
        Node<Integer> h = new Node<>(9);
        Node<Integer> i = new Node<>(8);

        a.setLeftChild(b);
        a.setRigthChild(c);
        b.setLeftChild(d);
        b.setRigthChild(e);
        c.setRigthChild(g);
        d.setLeftChild(f);
        g.setLeftChild(h);
        g.setRigthChild(i);

        System.out.println("Size of this tree is " + size(a));
    }
}
