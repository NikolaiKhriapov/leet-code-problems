class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = resultList.get(resultList.size() - 1);
            int[] currInterval = intervals[i];

            if (currInterval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
            } else {
                resultList.add(currInterval);
            }
        }
        
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}