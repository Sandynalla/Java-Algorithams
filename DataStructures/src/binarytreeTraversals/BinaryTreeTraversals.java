package binarytreeTraversals;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversals<T> {


    public static void print(Node node) {
        System.out.print(node.data + " ->");
    }

    public static void preOrder(Node node) {
        if(node == null) return;

        print(node);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null) return;

        inOrder(node.left);
        print(node);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        print(node);
    }

    public static void levelOrder(Node node) {
        if(node == null) return;

        Queue<Node> que = new LinkedList<Node>();
        que.add(node);
        while(!que.isEmpty()) {
            Node temp = que.poll();

            System.out.print(temp.data + " ->");
            if(temp.left != null) {
                 que.add(temp.left);
            }
            if(temp.right != null) {
                que.add(temp.right);
            }

        }
    }

    public static void preOrderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        stack.addFirst(root);
        while(!stack.isEmpty()){
            root = stack.pollFirst();
            System.out.print(root.data + " ->");
            if(root.right != null){
                stack.addFirst(root.right);
            }
            if(root.left!= null){
                stack.addFirst(root.left);
            }
        }
    }

    public static void inOrderItr(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst();
                System.out.print(node.data + " ->");
                node = node.right;
            }
        }
    }

    public static void postOrderItr(Node root){
        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            root = stack1.pollFirst();
            if(root.left != null){
                stack1.addFirst(root.left);
            }
            if(root.right != null){
                stack1.addFirst(root.right);
            }
            stack2.addFirst(root);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pollFirst().data + " ->");
        }
    }


    public static class Node<T> {

        T data;
        Node left;
        Node right;

        public Node(T data) {
            this.data = data;

        }

    }



    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> g = new Node<>(6);

          a.left = b;
          a.right = c;
          b.left = d;
          b.right = e;
          c.right = g;


        System.out.print("Pre Order Traversal -> ");
        preOrder(a);
        System.out.println();
        System.out.print("In Order Traversal -> ");
        inOrder(a);
        System.out.println();
        System.out.print("Post Order Traversal -> ");
        postOrder(a);
        System.out.println();
        System.out.print("Level Order Traversal -> ");
        levelOrder(a);
        System.out.println();
        System.out.print("Pre Order Traversal Itr -> ");
        preOrderItr(a);
        System.out.println();
        System.out.print("In Order Traversal Itr -> ");
        inOrderItr(a);
        System.out.println();
        System.out.print("Post Order Traversal Itr -> ");
        postOrderItr(a);
    }
}
