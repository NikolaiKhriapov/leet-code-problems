class Solution {
    private static final int MAX_FREQUENCY = 2;

    public int removeDuplicates(int[] nums) {
        if (nums.length <= MAX_FREQUENCY) {
            return nums.length;
        }
        
        int left = MAX_FREQUENCY;
        for (int i = MAX_FREQUENCY; i < nums.length; i++) {
            if (nums[i] != nums[left - MAX_FREQUENCY]) {
                nums[left] = nums[i];
                left++;
            }
        }
        return left;
    }
}
