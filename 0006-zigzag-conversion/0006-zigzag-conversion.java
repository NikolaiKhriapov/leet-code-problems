class Solution {
    public String convert(String s, int numRows) {
        if (s == null || numRows <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] buckets = buildBuckets(s, numRows);
        return mergeBuckets(buckets);
    }

    private StringBuilder[] buildBuckets(String s, int numRows) {
        StringBuilder[] buckets = new StringBuilder[numRows];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }

        int bucketIndex = 0;
        boolean isDown = true;

        for (char c : s.toCharArray()) {
            buckets[bucketIndex].append(c);

            if (isDown) {
                bucketIndex++;
            } else {
                bucketIndex--;
            }

            if (bucketIndex == 0) {
                isDown = true;
            } else if (bucketIndex == numRows - 1) {
                isDown = false;
            }
        }
        
        return buckets;
    }

    private String mergeBuckets(StringBuilder[] buckets) {
        StringBuilder result = new StringBuilder();
        for (StringBuilder bucket : buckets) {
            result.append(bucket);
        }
        return result.toString();
    }
}

// time  - O(n)
// space - O(m)