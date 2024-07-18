class Solution {
    public String addBinary(String a, String b) {   
        String longest = a.length() > b.length() ? a : b;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < longest.length(); i++) {
            int aN = getNumber(a, i);
            int bN = getNumber(b, i);
            int sum = aN + bN + carry;

            if (sum == 0) {
                sb.append(0);
            } else if (sum == 1) {
                sb.append(1);
                carry = 0;
            } else if (sum == 2) {
                sb.append(0);
                carry = 1;
            } else if (sum > 2) {
                sb.append(1);
                carry = 1;
            }
        }
        
        if (carry > 0) sb.append(1);

        char[] result = sb.toString().toCharArray();
        for (int i = 0; i < result.length / 2; i++) {
            char tmp = result[i];
            result[i] = result[result.length - 1 - i];
            result[result.length - 1 - i] = tmp;
        }

        return new String(result);
    }

    public int getNumber(String s, int i) {
        if (s.length() - 1 < i) return 0;
        return s.charAt(s.length() - 1 - i) - '0';
    }
}