public class Sorter {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > x) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = x;
        }
    }

    public static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    private static void divide(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int sorted[] = new int[end - start + 1];
        int left = start, right = mid + 1, i = 0;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                sorted[i++] = arr[left++];
            } else {
                sorted[i++] = arr[right++];
            }
        }
        while (left <= mid) {
            sorted[i++] = arr[left++];
        }
        while (right <= end) {
            sorted[i++] = arr[right++];
        }
        for (int j = 0; j < i; j++) {
            arr[start++] = sorted[j];
        }

    }

    public static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int pivot = partition(arr, low, high);
        qSort(arr, low, pivot - 1);
        qSort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int left = low - 1;
        for (int right = low; right < high; right++) {
            if (arr[right] < pivot) {
                int temp = arr[right];
                arr[right] = arr[++left];
                arr[left] = temp;
            }
        }
        arr[high] = arr[++left];
        arr[left] = pivot;
        return left;
    }
}
