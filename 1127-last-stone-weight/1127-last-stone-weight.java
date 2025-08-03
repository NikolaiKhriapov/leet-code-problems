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
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            int resultingStone = stone1 - stone2;
            if (resultingStone != 0) {
                maxHeap.offer(resultingStone);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}

// time. - O(n log n)
// space - O(n)