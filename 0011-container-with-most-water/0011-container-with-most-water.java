class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1; 
        int maxarea = 0; 
        while (i < j) {
            int currentArea = (j - i) * Math.min(height[i], height[j]);
            maxarea = Math.max(maxarea, currentArea);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxarea; 
    }
}
 