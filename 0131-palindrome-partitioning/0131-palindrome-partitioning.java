class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int start, List<String> curr, List<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                partition(s, i + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}