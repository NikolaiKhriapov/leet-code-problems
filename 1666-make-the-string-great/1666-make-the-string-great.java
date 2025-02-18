class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int sbL = sb.length();
            if (sbL != 0 && (sb.charAt(sbL - 1) == c + 32 || sb.charAt(sbL - 1) == c - 32)) {
                sb.deleteCharAt(sbL - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}