import java.util.*;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort to handle duplicates
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add current subset

        for (int i = start; i < nums.length; i++) {
            // Step 2: skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);                    // Include nums[i]
            backtrack(nums, i + 1, current, result); // Recurse
            current.remove(current.size() - 1);      // Backtrack
        }
    }
}
