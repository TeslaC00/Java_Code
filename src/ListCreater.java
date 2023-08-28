import java.util.Scanner;

// import dataStrcutures.list.CircularLinkedList;
// import dataStrcutures.list.SingleLinkedList;
import dataStrcutures.list.DoublyLinkedList;

public class ListCreater {
    DoublyLinkedList list;
    boolean running;
    static Scanner scanner;

    public ListCreater() {
        list = new DoublyLinkedList();
    }

    public void menu() {
        running = true;
        scanner = new Scanner(System.in);
        while (running) {
            System.out.println("**List Creater Menu**");
            System.out.println("1.Create a new list");
            System.out.println("2.Add elements to the list");
            System.out.println("3.Remove elements from the list");
            System.out.println("4.Clear list");
            System.out.println("5.View list");
            System.out.println("6.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createList();
                    break;
                case 2:
                    addToList();
                    break;
                case 3:
                    removeList();
                    break;
                case 4:
                    clearList();
                    break;
                case 5:
                    viewList();
                    break;
                case 6:
                    exit();
                    break;
                default:
                    System.out.println("Please give a valid input");
            }
        }
    }

    private void exit() {
        System.out.println("Sure wanna exit(y/n)?");
        char ch = scanner.next().charAt(0);
        if (ch == 'Y' || ch == 'y') {
            running = false;
            scanner.close();
            System.exit(0);
        }
    }

    private void createList() {
        if (list != null)
            list.clear();
        list = new DoublyLinkedList();
    }

    private void addToList() {
        System.out.println("\033[H\033[2J");
        System.out.println("1.Add at first");
        System.out.println("2.Add at mid");
        System.out.println("3.Add at last");
        System.out.println("4.Exit");
        int choice = scanner.nextInt();
        System.out.println("Give the data");
        int data = scanner.nextInt();
        switch (choice) {
            case 1:
                list.addFirst(data);
                break;

            case 2:
                System.out.println("Give the index");
                int index = scanner.nextInt();
                list.addMid(data, index);
                break;
            case 3:
                list.addLast(data);
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    private void removeList() {
        System.out.println("\033[H\033[2J");
        System.out.println("1.Remove at first");
        System.out.println("2.Remove at mid");
        System.out.println("3.Remove at last");
        System.out.println("4.Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                list.removeFirst();
                break;
            case 2:
                System.out.println("Give the index");
                int index = scanner.nextInt();
                list.removeMid(index);
                break;
            case 3:
                list.removeLast();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid input");
        }
    }

    private void clearList() {
        list.clear();
    }

    private void viewList() {
        list.display();
    }
}
