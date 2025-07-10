class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (totalSum - leftSum - nums[i] == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        
        return -1;
    }
}