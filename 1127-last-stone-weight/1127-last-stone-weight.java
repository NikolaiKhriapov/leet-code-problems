class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int n : stones) {
            queue.offer(n);
        }

        while (queue.size() > 1) {
            int res = queue.poll() - queue.poll();
            if (res > 0) {
                queue.offer(res);
            }
        }
        
        if (queue.size() == 1) {
            return queue.poll();
        }

        return 0;
    }
}