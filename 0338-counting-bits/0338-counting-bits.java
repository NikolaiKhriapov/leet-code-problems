class Solution {
    public int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.bitCount(i);
        }
        
        return result;
    }
}