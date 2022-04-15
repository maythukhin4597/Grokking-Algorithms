package chapter4;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {50, 30, 12, 293, 2, 3, 10, 60, 1, 43};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = swap(arr, begin, end);
            quickSort(arr, begin, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    static int swap(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int leftIndex = begin - 1;
        for (int i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[++leftIndex];
                arr[leftIndex] = arr[i];
                arr[i] = temp;
            }
        }
        // Finally, the pivot element is swapped with the left pointer
        int temp = arr[++leftIndex];
        arr[leftIndex] = arr[end];
        arr[end] = temp;
        return leftIndex;
    }
}
