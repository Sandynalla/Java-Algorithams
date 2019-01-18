public class IsBSTorNot {

    public static boolean isBSTorNot(Node node, int min, int max) {

        if(node == null) return true;

        if(node.getData() <= min || node.getData() > max) {
            return false;
        }

        return isBSTorNot(node.getLeftChild(), min, node.getData()) && isBSTorNot(node.getRightChild(), node.getData(), max);

    }


    public static class Node<T> {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;

        }

        public int getData() {
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
        Node<Integer> b = new Node<>(10);
        Node<Integer> c = new Node<>(19);
        Node<Integer> d = new Node<>(-3);
        Node<Integer> e = new Node<>(13);
        Node<Integer> f = new Node<>(21);

        a.setLeftChild(b);
        a.setRigthChild(c);
        b.setLeftChild(d);
        c.setLeftChild(e);
        c.setRigthChild(f);

        System.out.println("Find out if tree is a BST or Not? " + isBSTorNot(a, Integer.MIN_VALUE, Integer.MAX_VALUE));

    }
}