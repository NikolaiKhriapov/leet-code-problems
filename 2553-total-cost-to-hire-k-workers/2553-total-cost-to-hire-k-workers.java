class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        if (costs == null || k <= 0 || candidates <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<Integer> leftMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();

        int left = 0;
        int right = costs.length - 1;
        while (left <= right && leftMinHeap.size() < candidates) {
            leftMinHeap.offer(costs[left++]);
        }
        while (left <= right && rightMinHeap.size() < candidates) {
            rightMinHeap.offer(costs[right--]);
        }

        long totalCost = 0;
        while (k-- > 0) {
            if (leftMinHeap.isEmpty() && rightMinHeap.isEmpty()) {
                break;
            } else if (leftMinHeap.isEmpty()) {
                totalCost += rightMinHeap.poll();
            } else if (rightMinHeap.isEmpty()) {
                totalCost += leftMinHeap.poll();
            } else if (leftMinHeap.peek() <= rightMinHeap.peek()) {
                totalCost += leftMinHeap.poll();
                if (left <= right) {
                    leftMinHeap.offer(costs[left++]);
                }
            } else {
                totalCost += rightMinHeap.poll();
                if (left <= right) {
                    rightMinHeap.offer(costs[right--]);
                }
            }
        }
        
        return totalCost;
    }
}