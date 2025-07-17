class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0 || nums1.length != nums2.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long result = 0;
        for (int i = 0; i < pairs.length; i++) {
            minHeap.add(pairs[i][1]);
            sum += pairs[i][1];
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                result = Math.max(result, sum * (long) pairs[i][0]);
            }
        }

        return result;
    }
}