class Solution {
    public String removeStars(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!sb.isEmpty()) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}