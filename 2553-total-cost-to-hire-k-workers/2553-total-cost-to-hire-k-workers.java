class Solution {
    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Integer> minHeapLeft = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapRight = new PriorityQueue<>();
        
        int left = 0;
        int right = costs.length - 1;
        while (left <= right && minHeapLeft.size() < candidates) {
            minHeapLeft.add(costs[left++]);
        }
        while (left <= right && minHeapRight.size() < candidates) {
            minHeapRight.add(costs[right--]);
        }

        long totalCost = 0;
        while (k-- > 0) {
            if (minHeapLeft.isEmpty()) {
                totalCost += minHeapRight.poll();
            } else if (minHeapRight.isEmpty()) {
                totalCost += minHeapLeft.poll();
            } else if (minHeapLeft.peek() <= minHeapRight.peek()) {
                totalCost += minHeapLeft.poll();
                if (left <= right) {
                    minHeapLeft.add(costs[left++]);
                }
            } else {
                totalCost += minHeapRight.poll();
                if (left <= right) {
                    minHeapRight.add(costs[right--]);
                }
            }
        }
        
        return totalCost;
    }
}