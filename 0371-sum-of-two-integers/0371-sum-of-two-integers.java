class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}

// a = 0010, b = 0011
// a = 0001, b = 0100
// a = 0101, b = 0000