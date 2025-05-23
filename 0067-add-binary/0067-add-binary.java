class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        int l = la >= lb ? la : lb;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < l; i++) {
            int pa = la - 1 - i;
            int pb = lb - 1 - i;

            int na = (pa >= 0) ? (a.charAt(pa) - '0') : 0;
            int nb = (pb >= 0) ? (b.charAt(pb) - '0') : 0;
            int sum = na + nb + carry;

            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();
    }
}