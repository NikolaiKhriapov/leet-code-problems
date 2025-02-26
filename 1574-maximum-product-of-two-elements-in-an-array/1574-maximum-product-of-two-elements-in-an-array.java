class Solution {
    public int maxProduct(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int n : nums) {
            pq.add(n);
        }

        return (pq.poll() - 1) * (pq.poll() - 1);
    }
}