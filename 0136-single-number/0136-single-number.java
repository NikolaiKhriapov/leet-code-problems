class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;        
    }
}