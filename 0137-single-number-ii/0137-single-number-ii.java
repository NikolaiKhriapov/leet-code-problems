class Solution {
    private static final int REPETITIONS = 3;

    public int singleNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < bitCount.length; i++) {
                bitCount[i] += (num >> i) & 1;
            }
        }
        
        int result = 0;
        for (int i = 0; i < bitCount.length; i++) {
            result <<= 1;
            result += (bitCount[bitCount.length - 1 - i] % REPETITIONS);
        }

        return result;
    }
}
