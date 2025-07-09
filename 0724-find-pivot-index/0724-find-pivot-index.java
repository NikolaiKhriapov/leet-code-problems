class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] left = new int[nums.length];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            left[i] = currSum;
        }

        currSum = 0;
        int[] right = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            right[i] = currSum;
        }

        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}