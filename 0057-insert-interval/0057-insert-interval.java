class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || newInterval == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<int[]> list = new ArrayList<>();

        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        int p = 0;

        while (p < intervals.length && intervals[p][0] <= newInterval[0]) {
            list.add(intervals[p]);
            p++;
        }
        
        if (!list.isEmpty() && list.get(list.size() - 1)[1] >= newInterval[0]) {
            int[] prev = list.get(list.size() - 1);
            prev[1] = Math.max(prev[1], newInterval[1]);
        } else {
            list.add(newInterval);
        }

        int[] prev = list.get(list.size() - 1);
        while (p < intervals.length && prev[1] >= intervals[p][0]) {
            prev[1] = Math.max(prev[1], intervals[p][1]);
            p++;
        }
        
        for (int i = p; i < intervals.length; i++) {
            list.add(intervals[i]);
            p++;
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

// time  - O(n)
// space - O(n)