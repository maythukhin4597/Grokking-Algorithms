package chapter9;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println("Common substring count for fish and hish : " + commonString("fish", "hish"));
        System.out.println("Common substring count for vista and hish : " + commonString("vista", "hish"));
        System.out.println("Common substring count for fish and fosh : " + commonString("fish", "fosh"));
        System.out.println("Common substring count for fort and fosh : " + commonString("fort", "fosh"));
    }

    static int commonString(String first, String second) {
        int max = 0;
        int[][] cell = new int[first.length() + 1][second.length() + 1];

        for (int i = 1; i <= first.length(); i++) {
            for (int j = 1; j <= second.length(); j++) {
                char firstChar = first.charAt(i - 1);
                char secondChar = second.charAt(j - 1);
                if (firstChar == secondChar) {
                    cell[i][j] = cell[i - 1][j - 1] + 1;
                    max++;
                } else {
                    cell[i][j] = Math.max(cell[i][j - 1], cell[i - 1][j]);
                }
            }
        }
        return max;
    }
}
