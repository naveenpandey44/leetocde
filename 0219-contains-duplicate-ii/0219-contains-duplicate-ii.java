class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> j = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (j.containsKey(val) && i - j.get(val) <= k) {
                return true;
            }
            j.put(val, i);
        }

        return false;        
    }
}