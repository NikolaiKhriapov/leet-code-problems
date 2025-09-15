class Solution {
    public int getSum(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        while (a != 0 || b != 0 || carry > 0) {
            int digit = (a & 1) + (b & 1) + carry;
            sb.append(digit % 2);
            carry = digit / 2;
            a >>>= 1;
            b >>>= 1;
        }
        
        int result = 0;
        for (char c : sb.reverse().toString().toCharArray()) {
            result <<= 1;
            result += (c - '0');
        }

        return result;
    }
}

// time  - O()
// space - O()