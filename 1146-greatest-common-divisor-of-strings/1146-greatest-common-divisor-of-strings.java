class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int length1 = str1.length();
        int length2 = str2.length();

        int gcd = findGcd(length1, length2);
        String gcdStr = str1.substring(0, gcd);

        if (isPart(str1, gcdStr) && isPart(str2, gcdStr)) {
            return gcdStr;
        }
        return "";
    }

    private int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }

    private boolean isPart(String str, String sub) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < str.length()) {
            sb.append(sub);
            if (!str.startsWith(sb.toString())) {
                return false;
            }
        }
        return sb.length() == str.length();
    }
}