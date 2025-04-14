class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        List<int[]> list = new ArrayList<>();
        boolean[] used = new boolean[intervals.length];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            
            if (used[i]) {
                continue;
            }
            used[i] = true;

            for (int j = i + 1; j < intervals.length; j++) {
                int[] next = intervals[j];
                if (curr[1] < next[0]) {
                    break;
                } else {
                    curr[0] = Math.min(curr[0], next[0]);
                    curr[1] = Math.max(curr[1], next[1]);
                    used[j] = true;
                }
            }
            list.add(curr);
        }
        
        return listToArray(list);
    }

    private int[][] listToArray(List<int[]> list) {
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}