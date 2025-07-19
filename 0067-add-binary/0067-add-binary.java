class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder sb = new StringBuilder();
        int length = Math.max(a.length(), b.length());
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        int carry = 0;
        
        while (pa >= 0 || pb >= 0) {
            int na = (pa >= 0 ? a.charAt(pa--) : '0') - '0';
            int nb = (pb >= 0 ? b.charAt(pb--) : '0') - '0';
            
            int sum = na + nb + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}

// time  - O(n)
// space - O(n)