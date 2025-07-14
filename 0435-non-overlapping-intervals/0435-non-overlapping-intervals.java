class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int currEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= currEnd) {
                count++;
                currEnd = intervals[i][1];
            }
        }

        return intervals.length - count;
    }
}