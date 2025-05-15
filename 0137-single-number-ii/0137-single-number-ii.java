class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] bitCount = new int[32];

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitCount[i] += (num & 1);
                num >>= 1;
            }
        }
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 != 0) {
                int bit = 1 << i;
                result |= bit;
            }
        }

        return result;
    }
}