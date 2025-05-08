class Solution {
    private static final int FREQUENCY = 2;
    
    public int removeDuplicates(int[] nums) {
        if (nums.length <= FREQUENCY) {
            return nums.length;
        }
        
        int left = FREQUENCY;
        for (int i = FREQUENCY; i < nums.length; i++) {
            if (nums[i] != nums[left - FREQUENCY]) {
                nums[left] = nums[i];
                left++;
            }
        }

        return left;
    }
}