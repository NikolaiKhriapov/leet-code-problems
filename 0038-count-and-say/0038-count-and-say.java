class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = runLengthEncode(result);
        }
        return result;
    }

    private String runLengthEncode(String s) {
        StringBuilder result = new StringBuilder();

        int left = 0;
        for (int right = 1; right < s.length(); right++) {
            if (s.charAt(right) != s.charAt(left)) {
                result.append(right - left);
                result.append(s.charAt(left));
                left = right;
            }
        }
        result.append(s.length() - left);
        result.append(s.charAt(left));

        return result.toString();
    }
}

// time  - O(n)
// space - O(n)