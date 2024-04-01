package dataStrcutures.tree;

import java.util.ArrayList;

public class HeapSort {

    ArrayList<Integer> heap;

    public HeapSort(int size) {
        heap= new ArrayList<>(size);
    }

    public void add(int[] array) {
        for (int i : array) {
            heap.add(i);
            heapify(heap.size() - 1);
        }
    }

    public void heapify(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            int temp = heap.get(index);
            heap.set(index, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public int[] getArray() {
        int[] array = new int[heap.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = heap.get(i);
        }
        return array;
    }

}
