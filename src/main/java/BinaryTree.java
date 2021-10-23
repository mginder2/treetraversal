//Author: Matteo Ginder
//Date: 10/7/2021

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
    
    public BinaryTree(){
        
    }
    
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

    return current;
    }
    
    public void add(int value) {
        root = addRecursive(root, value);
    }
    
    public BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(8);
        bt.add(3);
        bt.add(10);
        bt.add(1);
        bt.add(6);
        bt.add(14);
        bt.add(4);
        bt.add(7);
        bt.add(13);

        return bt;
    }
    
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }
    
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
