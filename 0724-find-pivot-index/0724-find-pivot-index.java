class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int rightSum = 0;
        for (int n : nums) {
            rightSum += n;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}

// time  - O(n)
// space - O(n)