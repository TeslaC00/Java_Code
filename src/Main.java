public class Main {
    public static void main(String[] args) {
        int arr1[] = new int[10];
        for (int i = 0; i < 7; i++) {
            arr1[i] = i + 1;
        }
        display(arr1);
        insert(arr1, 2, 6, 90);
        display(arr1);
        delete(arr1, 2, 7);
        display(arr1);
        System.out.println(search(arr1, 5));
    }

    private static void insert(int array[], int pos, int elements, int value) {
        for (int i = elements; i >= pos; i--) {
            array[i + 1] = array[i];
        }
        array[pos] = value;
    }

    private static void delete(int array[], int pos, int elements) {
        for (int i = pos; i <= elements; i++) {
            array[i] = array[i + 1];
        }
    }

    private static boolean search(int array[], int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    private static void display(int array[]) {
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}