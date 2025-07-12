class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits == null || capital == null || k < 0 || w < 0 || profits.length != capital.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        PriorityQueue<Pair> minCapital = new PriorityQueue<>((a, b) -> Integer.compare(a.capital, b.capital));
        for (int i = 0; i < capital.length; i++) {
            minCapital.offer(new Pair(capital[i], profits[i]));
        }
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        while (k-- > 0) {
            while (!minCapital.isEmpty() && minCapital.peek().capital <= w) {
                maxProfits.offer(minCapital.poll().profit);
            }
            if (maxProfits.isEmpty()) {
                break;
            }
            w += maxProfits.poll();
        }
        
        return w;
    }

    private class Pair {
        int capital;
        int profit;

        public Pair(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}