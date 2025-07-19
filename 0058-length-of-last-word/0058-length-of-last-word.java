class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int right = s.length() - 1;
        while (right >= 0 && s.charAt(right) == ' ') {
            right--;
        }

        int left = right - 1;
        while (left >= 0 && s.charAt(left) != ' ') {
            left--;
        }
        
        return right - left;
    }
}

// time  - O(n)
// space - O(1)