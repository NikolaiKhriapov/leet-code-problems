class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Math.pow(2, 50) % n == 0;
    }
}