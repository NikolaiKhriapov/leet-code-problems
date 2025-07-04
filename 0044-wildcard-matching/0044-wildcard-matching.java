class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        return isMatch(s, p, 0, 0, new Boolean[s.length() + 1][p.length() + 1]);
    }

    private boolean isMatch(String s, String p, int ps, int pp, Boolean[][] memo) {
        if (memo[ps][pp] != null) {
            return memo[ps][pp];
        }

        if (pp >= p.length()) {
            memo[ps][pp] = ps >= s.length();
            return memo[ps][pp];
        }

        boolean isFirstCharMatch = ps < s.length() && (s.charAt(ps) == p.charAt(pp) || p.charAt(pp) == '?');

        if (p.charAt(pp) == '*') {
            memo[ps][pp] = (ps < s.length() && isMatch(s, p, ps + 1, pp, memo)) || isMatch(s, p, ps, pp + 1, memo);
        } else {
            memo[ps][pp] = isFirstCharMatch && isMatch(s, p, ps + 1, pp + 1, memo);
        }
        return memo[ps][pp];
    }
}