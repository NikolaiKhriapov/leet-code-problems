class Solution {
    public String addBinary(String a, String b) {
        int pa = a.length() - 1;
        int pb = b.length() - 1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (pa >= 0 || pb >= 0) {
            int na = (pa >= 0 ? a.charAt(pa) : '0') - '0';
            int nb = (pb >= 0 ? b.charAt(pb) : '0') - '0';
            int n = na + nb + carry;
            result.append(n % 2);
            carry = n / 2;
            pa--;
            pb--;
        }

        if (carry == 1) result.append(carry);
        return result.reverse().toString();
    }
}