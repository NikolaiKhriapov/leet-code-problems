class Solution {
    public void reverseString(char[] s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}

// time. - O(n)
// space - O(1)