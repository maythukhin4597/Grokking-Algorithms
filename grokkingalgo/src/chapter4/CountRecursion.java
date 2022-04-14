package chapter4;

import java.util.LinkedList;
import java.util.List;

public class CountRecursion {

    public static void main(String[] args) {
        List<Integer> numList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(countRecursion(numList));

        int[] numArr = {1, 2, 3, 4, 5};
        System.out.println(countRecursion(numArr.length));
    }

    /**
     * @param numList Use linkedlist to modify list by removing first item recursively
     * @return Total number of items in list using recursion
     */
    static int countRecursion(List<Integer> numList) {
        if (numList.size() < 1) {
            return 0;
        }
        if (numList.size() == 1) {
            return 1;
        }

        numList.remove(0);
        return 1 + countRecursion(numList);
    }

    /**
     * @param length
     * @return Total number of items in array by decrementing array length
     */
    static int countRecursion(int length) {
        if (length < 1) {
            return 0;
        }

        return 1 + countRecursion(--length);
    }
}
