class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int target = points[0][1];
        int arrows = 1;
        for (int[] point : points) {
            if (point[0] > target) {
                arrows++;
                target = point[1];
            }
        }
        return arrows;
    }
}