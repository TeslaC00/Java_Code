import java.util.Arrays;

public class BinarySearch {

    static int search(int arr[], int value) {
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (arr[mid] == value)
                return mid;
            else if (value > arr[mid]) {
                start = mid + 1;
            } else if (value < arr[mid]) {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }
}
