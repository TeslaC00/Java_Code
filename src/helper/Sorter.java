package helper;

public class Sorter {
    public static void main(String[] args) {
        Sort sort = new Sort();
        //int x[] = {21,32,12,42,12,3,1,8,56,45,34};
        int y[] = {21,32,12,42,12,3,1,8,56,45,34};
        sort.selectionSort(y, y.length);
        for(int i:y){
            System.out.println(i);
        }
    }
}

class Sort{

    //bubble sort
    void bubbleSort(int arr[], int n){
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //selection sort
    void selectionSort(int arr[], int n){
        for(int i=0; i<n-1; i++){
            int index = i;
            for(int j=i+1; j<n; j++){
                if(arr[index]>arr[j]){
                    index = j;
                }
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    //insertion sort
    void insertionSort(int arr[], int n){
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
