class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int right = points[0][1];
        int arrows = 1;
        for (int[] point : points) {
            if (point[0] > right) {
                arrows++;
                right = point[1];
            }
        }

        return arrows;
    }
}

// [10,16],[2,8],[1,6],[7,12]
// [1,6],[2,8],[7,12],[10,16]