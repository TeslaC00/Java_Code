public class BinarySearchTest {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(10);
        tree.insert(2);
        tree.insert(1);
        tree.insert(9);
        tree.insert(3);
        tree.insert(25);
        tree.insert(15);
        tree.display();
        System.out.println(tree.search(2));
    }
}
