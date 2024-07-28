class Solution {
    public int maxProduct(int[] nums) {

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            queue.offer(n);
        }

        return (queue.poll() - 1) * (queue.poll() - 1);
    }
}