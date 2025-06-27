class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0, memo);
    }

    private boolean isMatch(String s, String p, int ps, int pp, Boolean[][] memo) {
        if (memo[ps][pp] != null) {
            return memo[ps][pp];
        }

        if (pp >= p.length()) {
            memo[ps][pp] = ps >= s.length();
            return memo[ps][pp];
        }

        boolean isFirstMatch = ps < s.length() && (s.charAt(ps) == p.charAt(pp) || p.charAt(pp) == '.');

        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            memo[ps][pp] = isMatch(s, p, ps, pp + 2, memo) || (isFirstMatch && isMatch(s, p, ps + 1, pp, memo));
        } else {
            memo[ps][pp] = isFirstMatch && isMatch(s, p, ps + 1, pp + 1, memo);
        }
        return memo[ps][pp];
    }
}
