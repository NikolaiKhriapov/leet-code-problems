class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        char ch = chars[0];
        int count = 0;
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ch) {
                count++;
            } else {
                idx = helper(chars, idx, ch, count);
                ch = chars[i];
                count = 1;
            }
        }
        idx = helper(chars, idx, ch, count);

        return idx;
    }

    private static int helper(char[] chars, int idx, char ch, int count) {
        chars[idx++] = ch;
        if (count > 1) {
            for (char digit : String.valueOf(count).toCharArray()) {
                chars[idx++] = digit;
            }
        }
        return idx;
    }
}