package chapter2;

import java.util.Vector;

public class SelectionSortVector {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(50);
        vector.add(30);
        vector.add(12);
        vector.add(293);
        vector.add(2);
        vector.add(3);
        vector.add(10);
        vector.add(60);
        System.out.println(selectionSort(vector));
    }

    static Vector selectionSort(Vector<Integer> arr) {
        Vector<Integer> newVector = new Vector<>(arr.size());

        while (arr.size() > 0) {
            int minIndex = findMin(arr);
            newVector.add(arr.get(minIndex));
            arr.removeElementAt(minIndex);
        }
        return newVector;
    }

    static int findMin(Vector<Integer> arr) {
        int min = arr.get(0);
        int lastMinIndex = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
                lastMinIndex = i;
            }
        }
        return lastMinIndex;
    }
}
