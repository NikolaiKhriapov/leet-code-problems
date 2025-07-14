class Solution {
    public int compress(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        char prevChar = chars[0];
        int count = 0;
        int idx = 0;

        for (char currChar : chars) {
            if (currChar == prevChar) {
                count++;
            } else {
                idx = helper(chars, idx, prevChar, count);
                prevChar = currChar;
                count = 1;
            }
        }
        idx = helper(chars, idx, prevChar, count);
        return idx;
    }

    private int helper(char[] chars, int idx, char prevChar, int count) {
        chars[idx++] = prevChar;
        if (count > 1) {
            for (char ch : String.valueOf(count).toCharArray()) {
                chars[idx++] = ch;
            }
        }
        return idx;
    }
}