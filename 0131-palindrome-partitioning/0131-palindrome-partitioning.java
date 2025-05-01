class Solution {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void partition(String s, int index, List<String> curr, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curr));
        }

        int left = index;
        int right = index;
        while (right < s.length()) { 
            boolean isPalindrome = isPalindrome(s, left, right);
            if (isPalindrome) {
                curr.add(s.substring(left, right + 1));
                partition(s, right + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
            right++;
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
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