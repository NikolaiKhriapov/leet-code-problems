class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits == null || capital == null || k < 0 || w < 0 || profits.length != capital.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < capital.length; i++) {
            minCapital.offer(new int[] {capital[i], profits[i]});
        }
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        while (k-- > 0) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfits.offer(minCapital.poll()[1]);
            }
            if (maxProfits.isEmpty()) {
                break;
            }
            w += maxProfits.poll();
        }
        
        return w;
    }
}