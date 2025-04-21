class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void helper(String s, int l, List<String> curr, List<List<String>> result) {
        if (l >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int r = l; r < s.length(); r++) {
            if (isPalindrome(s, l, r)) {
                curr.add(s.substring(l, r + 1));
                helper(s, r + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}