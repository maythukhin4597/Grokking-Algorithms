package chapter4;

import java.util.LinkedList;
import java.util.List;

public class SumRecursion {
    public static void main(String[] args) {
        List<Integer> numList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(sumRecursion(numList));
        int[] numArr = {1, 2, 3, 4, 5};
        System.out.println(sumRecursion(0, numArr));
    }

    /**
     * @param numList Use linkedlist to modify list by removing first item recursively
     * @return Sum of numbers using recursion
     */
    private static int sumRecursion(List<Integer> numList) {
        if (numList.size() < 1) {
            return 0;
        }
        if (numList.size() == 1) {
            return numList.get(0);
        }
        int temp = numList.get(0);
        numList.remove(0);
        return temp + sumRecursion(numList);
    }

    /**
     * @param index  Use index to get the item from array
     * @param numArr
     * @return Sum of numbers using recursion
     */
    static int sumRecursion(int index, int[] numArr) {
        if (numArr.length < 1 || index >= numArr.length) {
            return 0;
        }

        int temp = numArr[index];
        return temp + sumRecursion(++index, numArr);
    }

}
