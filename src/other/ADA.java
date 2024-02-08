package other;

public class ADA {

    public static int fibonacci(int number) {
        if (number == 0)
            return 0;
        if (number == 1)
            return 1;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static int factorial(int number) {
        if (number == 0)
            return 1;
        return number * factorial(number - 1);
    }

    public static int factorial2(int number) {
        int answer = 1;
        for (int i = 1; i <= number; i++) {
            answer *= i;
        }
        return answer;
    }

    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j > 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i, temp;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j])
                    index = j;
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    public static void quickSort(int[] array) {
        quickSortPartition(array, 0, array.length - 1);
    }

    private static void quickSortPartition(int[] array, int low, int high) {
        if (low < high) {
            int pivot = quickSortSorter(array, low, high);
            quickSortSorter(array, low, pivot - 1);
            quickSortSorter(array, pivot + 1, high);
        }
    }

    private static int quickSortSorter(int[] array, int low, int high) {
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

    public static void mergeSort(int[] array) {
        mergeSortPartition(array, 0, array.length - 1);
    }

    private static void mergeSortPartition(int[] array, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSortPartition(array, start, mid);
        mergeSortPartition(array, mid + 1, end);
        mergeSortMerge(array, start, mid, end);
    }

    private static void mergeSortMerge(int[] array, int start, int mid, int end) {
        int[] sorted = new int[end - start + 1];
        int index = 0, left = start, right = mid + 1;
        while (left <= mid && right <= end) {
            if (array[left] < array[right])
                sorted[index++] = array[left++];
            else
                sorted[index++] = array[right++];
        }
        while(left<=mid){
            sorted[index++] = array[left++];
        }
        while(right<=end){
            sorted[index++] = array[right++];
        }
        for (int j = 0; j < sorted.length; j++) {
            array[start++] = sorted[j];
        }
    }

    public static int binarySearch(int[] array, int value){
        int low = 0,high=array.length-1;
        int mid = low + (high-low)/2;
        while (low<=high) {
            if(array[mid]<value) low = mid+1;
            else if(array[mid]>value) high = mid-1;
            else if(array[mid]==value) return mid;
            mid = low + (high-low)/2;
        }
        return - 1;
    }

    public static int[] findMinMax(int[] array, int low, int high){
        if(low==high){
            return new int[] {array[low],array[low]};
        }
        else if(low==high-1){
            int min = array[low]<array[high]? array[low]:array[high];
            int max = array[low]>array[high]? array[low]:array[high];
            return new int[] {min,max};
        }
        int mid = low + (high-low)/2;
        int[] first = findMinMax(array, low, mid);
        int[] second = findMinMax(array, mid+1, high);
        int min = first[0]<second[0]? first[0]:second[0];
        int max = first[1]>second[1]? first[1]:second[1];
        return new int[] {min,max};
    }

}
