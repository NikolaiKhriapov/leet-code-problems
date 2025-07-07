class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        int result = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0;
            int max = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int gcd = findGcd(dx, dy);
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

            result = Math.max(result, max + 1 + duplicates);
        }

        return result;
    }

    private int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }
}