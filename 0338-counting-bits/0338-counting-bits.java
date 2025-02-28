class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i / 2] + (i % 2);
        }
        return result;
    }
}