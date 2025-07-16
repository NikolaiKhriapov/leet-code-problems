class Solution {
    public int compress(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (chars.length == 0) {
            return 0;
        }

        char currChar = chars[0];
        int count = 0;
        int idx = 0;

        for (char ch : chars) {
            if (ch == currChar) {
                count++;
            } else {
                idx = helper(chars, idx, currChar, count);
                currChar = ch;
                count = 1;
            }
        }
        idx = helper(chars, idx, currChar, count);

        return idx;
    }

    private int helper(char[] chars, int idx, char currChar, int count) {
        chars[idx++] = currChar;
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                chars[idx++] = c;
            }
        }
        return idx;
    }
}