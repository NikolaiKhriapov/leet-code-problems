class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;        
    }
}