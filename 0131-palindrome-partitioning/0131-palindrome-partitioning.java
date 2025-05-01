class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        Boolean[][] memo = new Boolean[s.length()][s.length()];
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result, memo);
        return result;
    }

    private void partition(String s, int index, List<String> curr, List<List<String>> result, Boolean[][] memo) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        int left = index;
        int right = index;
        while (right < s.length()) { 
            if (isPalindrome(s, left, right, memo)) {
                curr.add(s.substring(left, right + 1));
                partition(s, right + 1, curr, result, memo);
                curr.remove(curr.size() - 1);
            }
            right++;
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
                memo[l][r] = false;
                return false;
            }

            l++;
            r--;
        }
        
        memo[left][right] = true;
        return true;
    }
}