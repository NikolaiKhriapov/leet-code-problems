class Solution {
    private static final int FREQUENCY = 3;
    private static final int BITS = 32;

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length % FREQUENCY != 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] bitsCount = new int[BITS];
        for (int n : nums) {
            for (int i = 0; i < bitsCount.length; i++) {
                bitsCount[i] += (n >> i) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < bitsCount.length;  i++) {
            result <<= 1;
            int freq = bitsCount[bitsCount.length - i - 1] % FREQUENCY;
            if (freq != 0) {
                if (freq != 1) {
                    throw new IllegalArgumentException("Invalid input");
                }
                result += 1;
            }
        }
        
        return result;
    }
}

// time  - O(n)
// space - O(1)