
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AvgLevelsOfBT {

    public static List avgLevelsOfBT(Node node) {

        List<Double> result = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            int n = queue.size();

            double sum = 0;
            for(int i=0; i<n; i++) {
                Node temp = queue.poll();
                sum = sum + (int)(temp.getData());

                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            result.add(sum/n);
        }
        return result;
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
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(1);
        Node<Integer> g = new Node<>(2);

        a.setLeftChild(b);
        a.setRigthChild(c);
        b.setLeftChild(d);
        b.setRigthChild(e);
        c.setRigthChild(g);


        System.out.println("Max Height of this tree is " + avgLevelsOfBT(a));
    }
}
