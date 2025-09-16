class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[] {i, 0});
        }
        
        List<List<Integer>> result = new ArrayList<>();
        while (!minHeap.isEmpty() && k-- > 0) {
            int[] curr = minHeap.poll();
            result.add(List.of(nums1[curr[0]], nums2[curr[1]]));
            if (curr[1] + 1 < nums2.length) {
                minHeap.offer(new int[] {curr[0], curr[1] + 1});
            }
        }

        return result;
    }
}