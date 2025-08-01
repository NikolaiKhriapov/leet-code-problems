class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length != 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicates++;
                } else {
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    String slopeKey = dy + "/" + dx;
                    slopeCount.put(slopeKey, slopeCount.getOrDefault(slopeKey, 0) + 1);
                    max = Math.max(max, slopeCount.get(slopeKey));
                }
            }
            result = Math.max(result, max + 1 + duplicates);
        }
        return result;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}