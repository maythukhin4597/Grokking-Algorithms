package chapter2;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {50, 30, 12, 293, 2, 3, 190, 60, 23};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    /**
     * Bubblesort repeatedly swap the adjacent elements if they are in the wrong order.
     * @param arr
     * @return sorted array
     */
    static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
