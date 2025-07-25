class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums1.length != nums2.length || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currSum = 0;
        long result = 0;
        for (int[] pair : pairs) {
            currSum += pair[1];
            minHeap.offer(pair[1]);
            if (minHeap.size() > k) {
                currSum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                result = Math.max(result, currSum * (long) pair[0]);
            }
        }

        return result;
    }
}

// [1,3,3,2], [2,1,3,4]

// [2,1],[1,3],[3,3],[4,2]
// [4,2],[3,3],[2,1],[1,3]

// sum = +2, [2]
// sum = +3, [2,3]
// sum = +1, [1,2,3], result = 6*2=12
// sum = +3-1, [2,3,3], result = 8*1=12