class Solution {
    public int longestPalindrome(String s) {

        Set<Character> set = new HashSet<>();

        int result = 0;
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                result += 2;
                set.remove(c);
            }
        }

        if (set.size() > 0) result++;

        return result;
    }
}