class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        if (n == 1) return "1";

        String prevString = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = 0; i < prevString.length(); i++) {
            count++;
            if (i < prevString.length() - 1 && prevString.charAt(i) == prevString.charAt(i + 1)) {
                continue;
            } else {
                sb.append(count).append(prevString.charAt(i));
                count = 0;
            }
        }
        if (count > 0) {
            sb.append(count).append(prevString.charAt(prevString.length() - 1));
        }

        return sb.toString();
    }
}