class Solution {
    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }

        String prevString = countAndSay(n - 1);
        return generateCurrString(prevString);
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
        // if (count > 0) {
        //     sb.append(count).append(str.charAt(str.length() - 1));
        // }
        return sb.toString();

    }
}