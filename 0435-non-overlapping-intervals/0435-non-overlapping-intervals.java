public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        
        int count = 0; // ham kitane bar count ko  remove kiya hu
        int end = Integer.MIN_VALUE; // To store the end time of last kept interval

        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                // No overlap to ham sahi rahega interval
                end = interval[1]; // Update end to current interval's end
            } 
            else {
                // Overlapping hoga to  remove  interval karege
                count++;
            }
        }

        return count;
    }
}