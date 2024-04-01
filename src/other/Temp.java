package other;

public class Temp {
    public static void main(String[] args) {
        int[] array = { 12, 34, 1, 87, 10 };
        printArray(array);
        quickSort(array);
        printArray(array);
        int[] a = { 12, 54, 667, 87, 56 };
        printArray(a);
        mergeSort(a);
        printArray(a);
    }

    private static void quickSort(int[] array) {
        quickSortDivide(array, 0, array.length - 1);
    }

    private static void quickSortDivide(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSortDivide(array, low, pivot - 1);
            quickSortDivide(array, pivot + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int left = low - 1;
        for (int right = low; right < high; right++) {
            if (array[right] < pivot) {
                int temp = array[right];
                array[right] = array[++left];
                array[left] = temp;
            }
        }
        array[high] = array[++left];
        array[left] = pivot;
        return left;
    }

    private static void mergeSort(int[] array) {
        mergeDivide(array, 0, array.length - 1);
    }

    private static void mergeDivide(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeDivide(array, start, mid);
        mergeDivide(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] sortedArray = new int[end - start + 1];
        int left = start, right = mid + 1, index = 0;
        while (left <= mid && right <= end) {
            sortedArray[index++] = (array[left] < array[right]) ? array[left++] : array[right++];
        }
        while (left <= mid) {
            sortedArray[index++] = array[left++];
        }
        while (right <= end) {
            sortedArray[index++] = array[right++];
        }
        System.arraycopy(sortedArray, 0, array, start, sortedArray.length);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
