class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n <= 0 || trust == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] trustees = new int[n + 1];
        int[] trusters = new int[n + 1];

        for (int[] t : trust) {
            trustees[t[0]]++;
            trusters[t[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (trustees[i] == 0 && trusters[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}

// time  - O(2^n)
// space - O(n)