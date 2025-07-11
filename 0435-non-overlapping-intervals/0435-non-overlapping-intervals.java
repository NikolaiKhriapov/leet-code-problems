class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
                count++;
            }
        }
        
        return intervals.length - count;
    }
}

// [[1,2],[2,3],[3,4],[1,3]]
// [[1,2],[1,3],[2,3],[3,4]]