class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : stones) {
            pq.add(n);
        }
        
        while (pq.size() != 1) {
            int one = pq.poll();
            int two = pq.poll();

            pq.add(Math.abs(one - two));
        }

        return pq.poll();
    }
}