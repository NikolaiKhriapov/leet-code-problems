class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}

// time  - O(n log k)
// space - O(k);