class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;
        for (int x : weights) {
            min = Math.max(min, x); 
            max += x;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            int D = 1;
            int sum = 0; 
            
            for (int x : weights) {
                if (sum + x > mid) {
                    D++; 
                    sum = 0;
                }
                sum += x;
            }
            
            if (D > days) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        
        return min; 
    }
}