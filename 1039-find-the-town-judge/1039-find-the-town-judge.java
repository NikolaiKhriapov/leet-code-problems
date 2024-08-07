class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] count = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int personA = trust[i][0];
            int personB = trust[i][1];

            count[personA]--;
            count[personB]++;
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) return i;
        }

        return -1;
    }
}