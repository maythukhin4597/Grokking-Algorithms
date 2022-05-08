package chapter2;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {50, 30, 12, 293, 2, 3, 10, 60};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }

    static int[] insertionSort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) continue;
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
