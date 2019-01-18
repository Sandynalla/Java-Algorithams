public class InvertBinaryTree {

    public static Node invertBinaryTree(Node node) {

        if(node != null) {
            Node temp = node.getLeftChild();

            node.setLeftChild(node.getRightChild());
            node.setRigthChild(temp);

            if(node.left!=null) {
                invertBinaryTree(node.getLeftChild());
            }
            if(node.right !=null) {
                invertBinaryTree(node.getRightChild());
            }
        }

        return node;
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

        System.out.println("Max Height of this tree is " + invertBinaryTree(a));
    }
}
