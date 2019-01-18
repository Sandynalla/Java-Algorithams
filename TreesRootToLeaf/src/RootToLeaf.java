import java.util.ArrayList;
import java.util.List;

public class RootToLeaf {

    public static boolean rootToLeaf(Node node, int sum, List result) {

        if(node == null) return false;

        if(node.getLeftChild() == null && node.getRightChild() == null) {
            if(node.getData() == sum) {
                result.add(node.getData());
                return true;
            } else {
                return false;
            }
        }

        if(rootToLeaf(node.getLeftChild(), sum - node.getData(), result ) || rootToLeaf(node.getRightChild(), sum - node.getData(), result)) {
                result.add(node.getData());
                return true;
        }

        return false;
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
        Node<Integer> b = new Node<>(16);
        Node<Integer> c = new Node<>(5);
        Node<Integer> d = new Node<>(-3);
        Node<Integer> e = new Node<>(6);
        Node<Integer> f = new Node<>(11);
        Node<Integer> g = new Node<>(2);
        Node<Integer> h = new Node<>(9);
        Node<Integer> i = new Node<>(8);

        a.setLeftChild(b);
        a.setRigthChild(c);
        b.setRigthChild(d);
        c.setLeftChild(e);
        c.setRigthChild(f);

        List<Integer> result = new ArrayList<>();

        boolean r = rootToLeaf(a, 26, result);
        System.out.println(r);
        if(r){
            for(int data: result) {
                System.out.print(data + " ");
            }
        }else{
            System.out.println("No path for sum " + 22);
        }
    }
}
