public class SorterTest {
    public static void main(String[] args) {
        int[] numbers = { 6, 21, 55, 12, 5, 7, 1 };
        Sorter.insertionSort(numbers);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
