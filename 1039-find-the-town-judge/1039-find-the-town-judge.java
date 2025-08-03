class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n < 1 || trust == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] trusters = new int[n + 1];
        int[] trustees = new int[n + 1];
        for (int[] t : trust) {
            trusters[t[0]]++;
            trustees[t[1]]++;
        }

        int candidate = 0;
        for (int i = 1; i <= n; i++) {
            if (trusters[i] == 0 && trustees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}

// [[1,2]]
// [0,1,0], [0,0,1]