class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        Boolean[][] memo = new Boolean[s.length()][s.length()];
        partition(s, 0, new ArrayList<>(), result, memo);
        return result;
    }

    private void partition(String s, int start, List<String> curr, List<List<String>> result, Boolean[][] memo) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i, memo)) {
                curr.add(s.substring(start, i + 1));
                partition(s, i + 1, curr, result, memo);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right, Boolean[][] memo) {
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int l = left;
        int r = right;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                memo[left][right] = false;
                return false;
            }
            l++;
            r--;
        }

        memo[left][right] = true;
        return true;
    }
}