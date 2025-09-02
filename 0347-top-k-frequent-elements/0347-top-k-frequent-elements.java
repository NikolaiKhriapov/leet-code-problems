class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (var entry : map.entrySet()) {
            minHeap.offer(new int[] {entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        if (minHeap.size() < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[k];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }
}

// time  - O(n + k*log(k))
// space - O(n)