class Solution {
    public int compress(char[] chars) {
        if (chars == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (chars.length == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        char prevChar = chars[0];
        for (char currChar : chars) {
            if (currChar == prevChar) {
                count++;
            } else {
                sb.append(prevChar);
                if (count > 1) {
                    sb.append(String.valueOf(count));
                }
                prevChar = currChar;
                count = 1;
            }
        }
        sb.append(prevChar);
        if (count > 1) {
            sb.append(String.valueOf(count));
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }
}