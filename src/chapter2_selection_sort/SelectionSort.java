package chapter2_selection_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {50, 30, 12, 293, 2, 3, 10, 60};
        Arrays.toString(selectionSort(arr));
    }

    static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int lastMinIndex = i;
            for (int j = 0; j < arr.length; j++) {
                if (i >= j || arr[i] == arr[j]) continue;
                if (min > arr[j]) {
                    min = arr[j];
                    lastMinIndex = j;
                }
            }
            arr[lastMinIndex] = arr[i];
            arr[i] = min;
        }
        return arr;
    }
}