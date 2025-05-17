class Solution {
    private static final int OCCURENCES = 3;

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
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
            if (bitCount[i] % OCCURENCES != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}