package dataStrcutures.tree;

public class BinarySearchTree {
    private class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    static public enum Order {
        INORDER, POSTORDER, PREORDER
    }

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int key) {
        root = new Node(key);
    }

    public void insert(int key) {
        root = insertKey(key, root);
    }

    private Node insertKey(int key, Node node) {

        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insertKey(key, node.left);

        } else {
            node.right = insertKey(key, node.right);

        }
        return node;
    }

    public boolean search(int key) {
        return searchKey(key, root);
    }

    private boolean searchKey(int key, Node node) {
        if (node == null)
            return false;

        if (node.key == key)
            return true;

        else if (key < node.key)
            return searchKey(key, node.left);
        else
            return searchKey(key, node.right);
    }

    public void traverse(Order order) {
        traverse(order, root);
        System.out.println();
    }

    private void traverse(Order order, Node node) {
        if (node == null) {
            return;
        }
        if (order == Order.PREORDER) {
            System.out.print(node.key + " ");
        }
        traverse(order, node.left);
        if (order == Order.INORDER) {
            System.out.print(node.key + " ");
        }
        traverse(order, node.right);
        if (order == Order.POSTORDER) {
            System.out.print(node.key + " ");
        }
    }

    public void delete(int key) {
        root = delete(key, root);
    }

    private Node delete(int key, Node node) {
        if (node == null)
            return null;
        if (key < node.key) {
            node.left = delete(key, node.left);
        } else if (key > node.key) {
            node.right = delete(key, node.right);
        } else {
            if (node.left == null && node.right == null)
                return null;

            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;
            Node IS = inorderSuccessor(node.right);
            node.key = IS.key;
            node.right = delete(IS.key, node.right);
        }
        return node;

    }

    private Node inorderSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        display(node.left);
        display(node.right);
    }
}
