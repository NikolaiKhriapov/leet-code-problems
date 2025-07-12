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
                chars[idx++] = ch;
                if (count > 1) {
                    for (char digit : String.valueOf(count).toCharArray()) {
                        chars[idx++] = digit;
                    }
                }
                ch = chars[i];
                count = 1;
            }
        }
        chars[idx++] = ch;
        if (count > 1) {
            for (char digit : String.valueOf(count).toCharArray()) {
                chars[idx++] = digit;
            }
        }

        return idx;
    }
}