class Solution {
    public int singleNumber(int[] nums) {

        int[] bitCount = new int[32];
        for (int num : nums) {
            for (int i = 0; i < bitCount.length; i++) {
                bitCount[i] += (num >> i) & 1;
            }
        }

        int result = 0;
        for (int i = 0; i < bitCount.length; i++) {
            if (bitCount[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}