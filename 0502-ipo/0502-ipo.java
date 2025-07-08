class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k < 0 || w < 0 || profits == null || capital == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new int[] {capital[i], profits[i]});
        }

        while (k-- > 0) {
            while (!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfit.add(minCapital.poll()[1]);
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll();
        }

        return w;
    }
}