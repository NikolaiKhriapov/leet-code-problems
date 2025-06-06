class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left < 0 || right < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int shift = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }
}