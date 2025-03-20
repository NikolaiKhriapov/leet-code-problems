class Solution {
    public String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();

        int l = la >= lb ? la : lb;
        
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < l; i++) {
            int ca = (la > i) ? (a.charAt(la - 1 - i) - '0') : 0;
            int cb = (lb > i) ? (b.charAt(lb - 1 - i) - '0') : 0;

            int sum = ca + cb + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}