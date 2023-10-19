public class SorterTest {
    public static void main(String[] args) {
        int[] numbers = { 6, 21, 55, 12, 5, 7, 1 };
        System.out.println("Array before sorting");
        for(int i: numbers) {
            System.out.print(i+" ");
        }
        System.out.println("\nArray after sorting");
        Sorter.quickSort(numbers);
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
