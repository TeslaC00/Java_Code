public class BinarySearchTree {
    private class Node {
        int key;
        Node left, right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree(int key) {
        root = new Node(key);
    }

    public void insert(int key) {
        insertKey(key, root);
    }

    private void insertKey(int key, Node node) {
        if (key < node.key) {
            if (node.left == null) {
                node.left = new Node(key);
            } else {
                insertKey(key, node.left);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(key);
            } else {
                insertKey(key, node.right);
            }
        }
    }

    public boolean search(int key) {
        return searchKey(key, root);
    }

    private boolean searchKey(int key, Node node) {
        if (node == null)
            return false;

        if (node.key != key) {
            if (key < node.key)
                return searchKey(key, node.left);
            else
                return searchKey(key, node.right);
        }
        return true;
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
