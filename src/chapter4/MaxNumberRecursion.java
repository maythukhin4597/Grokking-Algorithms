package chapter4;

import java.util.LinkedList;
import java.util.List;

public class MaxNumberRecursion {

    public static void main(String[] args) {
        List<Integer> numList = new LinkedList<>(List.of(1, 2, 3, 4, 5, 45, 12, 3, 4, 22, 3, 10));
        System.out.println(maxRecursion(numList));
        int[] numArr = {1, 2, 3, 4, 5, 45, 12, 3, 4, 22, 3, 10};
        System.out.println(maxRecursion(0, numArr));
    }

    /**
     * @param numList Use linkedlist to modify list by removing first item recursively
     * @return Max number using recursion
     */
    static int maxRecursion(List<Integer> numList) {
        if (numList.size() < 1) {
            return 0;
        }
        if (numList.size() == 1) {
            return numList.get(0);
        }
        int temp = numList.get(0);
        numList.remove(0);
        return Math.max(temp, maxRecursion(numList));
    }

    /**
     * @param index  Use index to get the item from array
     * @param numArr
     * @return Max number using recursion
     */
    static int maxRecursion(int index, int[] numArr) {
        if (numArr.length < 1 || index >= numArr.length) {
            return 0;
        }
        int temp = numArr[index];
        return Math.max(temp, maxRecursion(++index, numArr));
    }

}
