class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int gcd = findGcd(str1.length(), str2.length());
        String gcdStr = str1.substring(0, gcd);

        return Objects.equals(str1 + str2, str2 + str1) ? gcdStr : "";
    }

    private int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }
}