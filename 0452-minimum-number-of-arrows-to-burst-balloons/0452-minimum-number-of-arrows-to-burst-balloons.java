class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            int right = points[i][1];
            while (i < points.length && points[i][0] <= right) {
                i++;
            }
            i--;
            count++;
        }
        return count;
    }
}