class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            maxHeap.offer(first - second);
        }
        
        return maxHeap.poll();
    }
}

// time. - O(n log n)
// space - O(n)