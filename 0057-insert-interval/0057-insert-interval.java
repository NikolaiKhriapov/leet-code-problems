class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int index = 0;
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            list.add(intervals[index]);
            index++;
        }

        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        list.add(newInterval);

        while (index < intervals.length) {
            list.add(intervals[index]);
            index++;
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}