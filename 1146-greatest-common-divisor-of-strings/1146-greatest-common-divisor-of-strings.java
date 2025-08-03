class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}

// time  - O(log n)
// space - O(n + m)