class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];

        // Step 1: Precompute all palindromes
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) &&
                    (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        // Step 2: Backtracking using precomputed DP
        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}