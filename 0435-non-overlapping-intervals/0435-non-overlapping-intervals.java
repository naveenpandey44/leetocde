public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int finish = intervals[i][1];

            if (start >= end) {
                end = finish;
            } else {
                count++;
            }
        }

        return count;
    }
}