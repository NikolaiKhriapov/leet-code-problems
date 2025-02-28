class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] countVoters = new int[n + 1];
        int[] countVotes = new int[n + 1];

        for (int[] arr : trust) {
            countVoters[arr[0]]++;
            countVotes[arr[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            if (countVoters[i] == 0 && countVotes[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}