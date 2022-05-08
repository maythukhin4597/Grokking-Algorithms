package chapter1;

import java.util.Objects;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 8, 9};
        int[] emptyArr = {};
        int[] nullArr = null;
        int[] singleArr = {1};
        int[] doubleArr = {1, 2};
        int index = binarySearch(doubleArr, 2);
        String resultMsg = index >= 0 ? "Found at " + index : "Not found";
        System.out.println(resultMsg);
    }

    static int binarySearch(int[] arr, int item) {
        boolean isFound = false;
        if (Objects.isNull(arr) || arr.length == 0) {
            return -1;
        }

        int begin = 0, last = arr.length - 1, mid = -1, midItem = 0;

        while (begin <= last) {
            mid = (begin + last) / 2;
            if ((midItem = arr[mid]) == item) {
                isFound = true;
                break;
            }
            if (item > midItem) {
                begin = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return isFound ? mid : -1;
    }
}
