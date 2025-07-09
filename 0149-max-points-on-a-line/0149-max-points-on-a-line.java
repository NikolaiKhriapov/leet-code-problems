class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int sum = 0;;
            int duplicates = 0;
            for (int j  = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicates++;
                } else {
                    int gcd = findGcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    String slopeKey = dy + "/" + dx;
                    slopeCount.put(slopeKey, slopeCount.getOrDefault(slopeKey, 0) + 1);
                    sum = Math.max(sum, slopeCount.get(slopeKey));
                }
            }
            result = Math.max(result, sum + 1 + duplicates);
        }
        return result;
    }

    private int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }
}