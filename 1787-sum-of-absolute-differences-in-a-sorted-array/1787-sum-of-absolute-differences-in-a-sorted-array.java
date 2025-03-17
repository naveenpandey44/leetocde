class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        result[0] = 0;

        // Prefix Sum Calculation
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + nums[i - 1];
        }

        // Suffix Sum Calculation
        int suffix = 0;
        for (int j = n - 1; j >= 0; j--) { // Changed i to j
            int left = (j * nums[j] - result[j]);
            int right = (suffix - (((n - (j + 1)) * nums[j])));
            result[j] = left + right;
            suffix = suffix + nums[j];
        }

        // Print output without commas
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(result[i]); // No space at the end
            } else {
                System.out.print(result[i] + " "); // Space instead of comma
            }
        }

        return result; // Added return statement
    }
}
