class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for (int i = 0; i < score.length; i++) {
            pq.add(new int[] {score[i], i});
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int[] el = pq.poll();

            String s = String.valueOf(rank);
            if (rank == 1) s = "Gold Medal";
            if (rank == 2) s = "Silver Medal";
            if (rank == 3) s = "Bronze Medal";

            result[el[1]] = s;
            rank++;
        }

        return result;
    }
}