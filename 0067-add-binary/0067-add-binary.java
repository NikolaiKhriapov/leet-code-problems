class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int l = a.length() > b.length() ? a.length() : b.length();
        
        while (a.length() < l) a = "0" + a;
        while (b.length() < l) b = "0" + b;

        int carry = 0;
        for (int i = l - 1; i >= 0; i--) {
            int bit = (a.charAt(i) - '0') + (b.charAt(i) - '0') + carry;
            sb.append(bit % 2);
            carry = bit / 2;
        }
        if (carry == 1) sb.append("1");

        return sb.reverse().toString();
    }
}