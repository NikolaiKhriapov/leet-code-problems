class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            int num = s.charAt(i) - '0';
            if (num == 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1 && (s.charAt(i) < '2' || (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}