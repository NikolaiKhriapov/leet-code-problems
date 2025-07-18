class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {

        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long result = 0;
        long sum = 0;
        for (int i = 0; i < pairs.length; i++) {
            sum += pairs[i][1];
            minHeap.offer(pairs[i][1]);
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

// [2,1], [1,3], [3,3], [4,2]
// [4,2], [3,3], [2,1], [1,3]

// sum = +2, [2]
// sum = +3, [2,3]
// sum = +1, [1,2,3]   result = 6*2=12
// sum = +3-1, [2,3,3] result = 8*1=12
