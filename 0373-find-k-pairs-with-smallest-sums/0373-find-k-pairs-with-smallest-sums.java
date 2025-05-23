class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || k < 0 || nums1.length == 0 || nums2.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(nums1[a[0]] + nums2[a[1]], nums1[b[0]] + nums2[b[1]]));
        
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.add(new int[]{i, 0});
        }

        while (k-- > 0) {
            int[] pair = pq.poll();
            result.add(List.of(nums1[pair[0]], nums2[pair[1]]));
            if (pair[1] + 1 < nums2.length) {
                pq.add(new int[]{pair[0], pair[1] + 1});
            }
        }

        return result;
    }
}