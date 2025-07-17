class Solution {
    public String removeStars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.delete(sb.length() - 1, sb.length());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}