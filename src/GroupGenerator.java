import java.util.ArrayList;
import java.util.Random;

public class GroupGenerator {
    public static void main(String[] args) {
        String[] array = { "Jethalal", "Tarak", "Babita", "Daya", "Bhide", "Abdul", "Iyer", "Anjali" };
        groupArray(array);
    }

    private static void groupArray(String[] array) {
        System.out.println("Assigning...");
        ArrayList<String[]> group = generate2DList(array.length);
        int index = 0, id = 1;
        for (String[] strings : group) {
            System.out.print("Group " + id + ": ");
            for (int i = 0; i < strings.length; i++) {
                strings[i] = array[index++];
                System.out.print(strings[i] + " ");
            }
            System.out.println();
            id++;
        }
    }

    private static ArrayList<String[]> generate2DList(int length) {
        System.out.println("Generating Group...");
        ArrayList<String[]> group = new ArrayList<>();
        Random random = new Random();
        int i;
        while (length >= 0) {
            if (length == 1) {
                i = 1;
                length--;
            } else {
                i = random.nextInt(1, length);
            }
            group.add(new String[i]);
            length -= i;
        }
        return group;
    }
}
