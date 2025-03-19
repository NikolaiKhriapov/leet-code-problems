class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int i = 0; i < score.length; i++) {
            pq.add(new int[] {i, score[i]});
        }
        
        int order = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            String s = String.valueOf(order);
            if (order == 1) s = "Gold Medal";
            if (order == 2) s = "Silver Medal";
            if (order == 3) s = "Bronze Medal";

            result[curr[0]] = s;
            order++;
        }

        return result;
    }
}