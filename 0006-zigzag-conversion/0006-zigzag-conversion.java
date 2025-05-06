class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 1) {
            return s;
        }
        if (numRows <= 0) {
            return "";
        }
        
        StringBuilder[] buckets = new StringBuilder[numRows];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }
        populateBuckets(s, buckets);
        return mergeBuckets(buckets);
    }

    private void populateBuckets(String s, StringBuilder[] buckets) {
        int bucketIndex = 0;
        boolean isForward = true;
        for (int i = 0; i < s.length(); i++) {
            buckets[bucketIndex].append(s.charAt(i));

            if (bucketIndex == 0) {
                isForward = true;
            }
            if (bucketIndex == buckets.length - 1) {
                isForward = false;
            }

            if (isForward) {
                bucketIndex++;
            } else {
                bucketIndex--;
            }
        }
    }

    private String mergeBuckets(StringBuilder[] buckets) {
        StringBuilder result = new StringBuilder();
        for (StringBuilder bucket : buckets) {
            result.append(bucket);
        }
        return result.toString();
    }
}