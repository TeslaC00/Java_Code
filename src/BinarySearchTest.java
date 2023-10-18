import dataStrcutures.tree.BinarySearchTree;
import dataStrcutures.tree.BinarySearchTree.Order;

public class BinarySearchTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.insert(2);
        tree.insert(1);
        tree.insert(9);
        tree.insert(3);
        tree.insert(25);
        tree.insert(15);
        System.out.println("Tree INORDER traversal:");
        tree.traverse(Order.INORDER);
        tree.delete(1);
        System.out.println("Tree delete key 1:");
        tree.traverse(Order.INORDER);
        System.out.println("Tree delete key 10, POSTORDER:");
        tree.delete(10);
        tree.traverse(Order.POSTORDER);
    }
}
