class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }

        // create buckets for each row
        StringBuilder[] buckets = new StringBuilder[numRows];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new StringBuilder();
        }
        
        // populate buckets
        int index = 0;
        int bucketIndex = 0;
        boolean isForward = true;
        while (index < s.length()) {
            buckets[bucketIndex].append(s.charAt(index));

            if (bucketIndex == 0) {
                isForward = true;
            } else if (bucketIndex == buckets.length - 1) {
                isForward = false;
            }

            if (isForward) {
                bucketIndex++;
            } else {
                bucketIndex--;
            }

            index++;
        }

        // merge all buckets
        StringBuilder result = new StringBuilder();
        for (StringBuilder bucket : buckets) {
            result.append(bucket);
        }

        return result.toString();
    }
}