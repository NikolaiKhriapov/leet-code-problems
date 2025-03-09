class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int pa = a.length() - 1;
        int pb = b.length() - 1;

        int carry = 0;
        while (pa >= 0 || pb >= 0) {
            int ba = (pa >= 0) ? (a.charAt(pa) - '0') : 0;
            int bb = (pb >= 0) ? (b.charAt(pb) - '0') : 0;
            int bit = ba + bb + carry;
            sb.append(bit % 2);
            carry = bit / 2;
            pa--;
            pb--;
        }
        if (carry == 1) sb.append(carry);

        return sb.reverse().toString();
    }
}