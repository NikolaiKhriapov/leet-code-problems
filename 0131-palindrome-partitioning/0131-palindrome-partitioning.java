class Solution {
    public List<List<String>> partition(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(String s, int left, List<String> curr, List<List<String>> result) {
        if (left == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int right = left; right < s.length(); right++) {
            if (isPalindrome(s, left, right)) {
                curr.add(s.substring(left, right + 1));
                helper(s, right + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// time  - O(n^2)
// space - O(n)