public class MergeBinaryTrees {

    public static Node mergeTrees(Node node1, Node node2) {

        if(node1 == null) return node2;
        if(node2 == null) return node1;

        node1.data = node1.data + node2.data;
        System.out.print(node1.data + " ->");

        node1.setLeftChild(mergeTrees(node1.getLeftChild(), node2.getLeftChild()));

        node1.setRigthChild(mergeTrees(node1.getRightChild(), node2.getRightChild()));

        return node1;

    }


    public static class Node {

        Integer data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;

        }

        public int getData() {
            return this.data;
        }

        public Node getLeftChild() {
            return this.left;
        }

        public void setLeftChild(Node leftChild) {
            this.left = leftChild;
        }

        public Node getRightChild() {
            return this.right;
        }

        public void setRigthChild(Node rightChild) {
            this.right = rightChild;
        }
    }

    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(3);
        Node c = new Node(6);
        Node g = new Node(8);


        a.setLeftChild(b);
        a.setRigthChild(c);
        b.setLeftChild(g);

        Node d = new Node(1);
        Node e = new Node(2);
        Node f = new Node(3);

        d.setLeftChild(e);
        d.setRigthChild(f);



        System.out.println("Merged Binary Tree " + mergeTrees(a, d));
    }
}
