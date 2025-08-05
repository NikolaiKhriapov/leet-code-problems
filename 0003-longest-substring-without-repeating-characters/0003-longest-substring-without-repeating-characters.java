class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        int left = 0;
        int right = 0;
        while (right < s.length()) {
            while (!set.add(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            right++;
            maxLength = Math.max(maxLength, set.size());
        }
        
        return maxLength;
    }
}

// time  - O(n)
// space - O(n)