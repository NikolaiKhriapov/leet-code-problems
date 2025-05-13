class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i < dp.length - 2 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
