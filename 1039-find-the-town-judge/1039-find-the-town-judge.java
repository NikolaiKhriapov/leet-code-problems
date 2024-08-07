class Solution {
    public int findJudge(int n, int[][] trust) {

        int[] trustCount = new int[n + 1];
        int[] trustedCount = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            int personA = trust[i][0];
            int personB = trust[i][1];

            trustCount[personA]++;
            trustedCount[personB]++;
        }

        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && trustedCount[i] == n - 1) return i;
        }

        return -1;
    }
}