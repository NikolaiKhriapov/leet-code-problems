class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = generateCurrString(result);
        }
        return result;
    }

    private static String generateCurrString(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                continue;
            } else {
                sb.append(count).append(str.charAt(i));
                count = 0;
            }
        }
        return sb.toString();

    }
}