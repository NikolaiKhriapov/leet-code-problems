class Solution {
    public List<List<String>> partition(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result, new Boolean[s.length()][s.length()]);
        return result;
    }

    private void helper(String s, int left, List<String> curr, List<List<String>> result, Boolean[][] memo) {
        if (left == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int right = left; right < s.length(); right++) {
            if (isPalindrome(s, left, right, memo)) {
                curr.add(s.substring(left, right + 1));
                helper(s, right + 1, curr, result, memo);
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

// time  - O(n3)
// space - O(n2)
