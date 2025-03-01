class Solution {
    public String addBinary(String a, String b) {
        while (a.length() != b.length()) {
            if (a.length() < b.length()) a = "0" + a;
            else b = "0" + b;
        }

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int n = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            result.append(n % 2);
            carry = 0;
            if (n > 1) carry = 1;
        }

        if (carry == 1) result.append(carry);
        return result.reverse().toString();
    }
}