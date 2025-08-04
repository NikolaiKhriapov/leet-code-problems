class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            int currDiff = nums[i] - nums[i - k + 1];
            minDiff = Math.min(minDiff, currDiff);
        }
        
        return minDiff;
    }
}

// time  - O(n log n)
// space - O(1)