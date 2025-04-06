// Approach -1

public class Solution {
    public boolean isMatch(String s, String p) {
        int n = p.length(); // Length of the pattern
        int m = s.length(); // Length of the text

        // Create a 2D array to store the result of subproblems
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call the recursive helper function to perform wildcard matching
        return isMatchUtil(p, s, n - 1, m - 1, dp) == 1;
    }

    // Helper method to check if the pattern matches the text
    static int isMatchUtil(String pattern, String text, int i, int j, int[][] dp) {
        // Base Cases
        if (i < 0 && j < 0) {
            return 1; // Both strings are empty, and the pattern matches.
        }
        if (i < 0 && j >= 0) {
            return 0; // Pattern is empty, but there are characters left in text.
        }
        if (j < 0 && i >= 0) {
            // Text is empty, check if remaining characters in pattern are all '*'.
            return isAllStars(pattern, i) ? 1 : 0;
        }

        // If the result is already computed, return it.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If the characters match or pattern has a '?', continue matching the rest of the strings.
        if (pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?') {
            return dp[i][j] = isMatchUtil(pattern, text, i - 1, j - 1, dp);
        } else {
            if (pattern.charAt(i) == '*') {
                // Two possibilities when encountering '*':
                // 1. '*' matches one or more characters in text.
                // 2. '*' matches zero characters in text.
                return dp[i][j] = (isMatchUtil(pattern, text, i - 1, j, dp) == 1 || isMatchUtil(pattern, text, i, j - 1, dp) == 1) ? 1 : 0;
            } else {
                // Characters don't match, and pattern[i] is not '*'.
                return 0;
            }
        }
    }

    // Helper method to check if the remaining characters in the pattern are all '*'
    static boolean isAllStars(String pattern, int i) {
        for (int j = 0; j <= i; j++) {
            if (pattern.charAt(j) != '*') {
                return false;
            }
        }
        return true;
    }
}