class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals[0].length != 2) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> intervalsList = mergeIntervals(intervals);
        return transformListIntoArray(intervalsList);
    }

    private List<int[]> mergeIntervals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = list.get(list.size() - 1);
            int[] currInterval = intervals[i];
            
            if (currInterval[0] > lastInterval[1]) {
                list.add(currInterval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
            }
        }

        return list;
    }

    private int[][] transformListIntoArray(List<int[]> list) {
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}