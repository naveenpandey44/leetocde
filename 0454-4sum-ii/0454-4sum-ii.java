class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        // Store sums of pairs from nums1 and nums2 in the map
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        // Check sums of pairs from nums3 and nums4 against the map
        for (int c : nums3) {
            for (int d : nums4) {
                int sum = -(c + d);
                count += map.getOrDefault(sum, 0);
            }
        }
        
        return count;
    }
}