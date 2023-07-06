import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private static ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mainMenu();
            int choice = takeInput();
            switch (choice) {
                case 0:
                    confirmExit();
                    break;
                case 1:
                    showAllList();
                    break;
                case 2:
                    addNewList();
                    break;
                case 3:
                    removeList();
                    break;
                case 4:
                    selectList();
                    break;
                case 5:
                    giveTask();
                    break;
                case 6:
                    clearAllList();
                    break;
                case 7:
                    clearSrc();
                    break;
                case 8:
                    save();
                    break;
                case 9:
                    load();
                    break;
                default:
                    System.out.println("That is not a choice");
                    confirmExit();
            }
        }
    }

    private static void load() {
    }

    private static void save() {
    }

    private static void clearSrc() {
        System.out.println("\033[H\033[2J");
    }

    private static void confirmExit() {
        System.out.println("Wanna Quit ?");
        String confirmation = scan.nextLine();
        if (confirmation.equalsIgnoreCase("yes")) {
            System.exit(0);
        } else {
            clearSrc();
            mainMenu();
        }
    }

    private static void mainMenu() {
        System.out.println("1.See all list");
        System.out.println("2.Add new list");
        System.out.println("3.Remove list");
        System.out.println("4.Select a list");
        System.out.println("5.Give a random task");
        System.out.println("6.Clear all list");
        System.out.println("7.Clear screen");
        System.out.println("8.Save");
        System.out.println("9.Load");
        System.out.println("0.Exit");
    }

    private static int takeInput() {
        String input = scan.next();
        int number = -1;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            takeInput();
        }
        return number;
    }

    private static void clearAllList() {
        lists.clear();
    }

    private static void giveTask() {
    }

    private static void selectList() {
    }

    private static void removeList() {
    }

    private static void addNewList() {
        ArrayList<String> temp = new ArrayList<String>();
        System.out.println("Press q to finish adding to list");
        while (scan.hasNext()) {
            String task = scan.next();
            if (task.equalsIgnoreCase("q")) {
                break;
            }
            temp.add(task);
        }
        lists.add(temp);
    }

    private static void showAllList() {
        for (ArrayList<String> list : lists) {
            for (String task : list) {
                if (!task.isBlank()) {
                    System.out.println(task);
                }
            }
            System.out.println();
        }
    }
}
