package chapter9;

import java.util.Arrays;

public class KnapsackDPSimple {
    public static void main(String[] args) {
        int[] weights = {1, 4, 3};
        int[] values = {15, 30, 20};
        int maxWeight = 4;
        System.out.println("max value of items : " + knapsack(weights, values, maxWeight, values.length));
    }

    static int knapsack(int[] weights, int[] values, int maxWeight, int totalItems) {
        if (maxWeight <= 0 || totalItems == 0) {
            return 0;
        }

        int[][] cell = new int[totalItems + 1][maxWeight + 1];

        for (int i = 1; i <= totalItems; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                // current item cannot fit in the cell
                if (j < weights[i - 1]) {
                    cell[i][j] = cell[i - 1][j];
                } else {
                    // previous max (value at cell[i-1][j]
                    int previousMax = cell[i - 1][j];
                    // value of current item + value of remaining space cell[i-1][j-item's weight]
                    int newEstimateMax = values[i - 1] + cell[i - 1][j - weights[i - 1]];
                    cell[i][j] = Math.max(previousMax, newEstimateMax);
                }
            }
        }

        for (int i = 0; i <= totalItems; i++) {
            System.out.println(Arrays.toString(cell[i]));
        }
        return cell[totalItems][maxWeight];
    }
}
