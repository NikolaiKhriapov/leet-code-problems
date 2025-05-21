class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return helper(s, k, 0, s.length());
    }

    private int helper(String s, int k, int l, int r) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = l; i < r; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean isValid = true;
        int longest = 0;
        int start = l;
        for (int i = l; i < r; i++) {
            if (map.get(s.charAt(i)) < k) {
                isValid = false;
                longest = Math.max(longest, helper(s, k, start, i));
                start = i + 1;
            }
        }

        if (isValid) {
            return r - l;
        }
        if (r > start) {
            longest = Math.max(longest, helper(s, k, start, r));
        }

        return longest;

    }
}