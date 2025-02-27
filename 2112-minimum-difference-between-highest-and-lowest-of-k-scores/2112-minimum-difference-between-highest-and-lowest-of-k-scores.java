class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        int l = 0;
        int r = (nums.length > k ? k : nums.length) - 1;

        while (r < nums.length) {
            int diff = nums[r] - nums[l];
            result = Math.min(result, diff);
            l++;
            r++;
        }

        return result;
    }
}