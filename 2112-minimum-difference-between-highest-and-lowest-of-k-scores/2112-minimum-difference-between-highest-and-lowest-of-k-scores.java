class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (nums.length < 2) return 0;

        int l = 0;
        int r = k - 1;

        int min = Integer.MAX_VALUE;

        Arrays.sort(nums);
        while (r < nums.length) {
            min = Math.min(min, nums[r] - nums[l]);
            l++;
            r++;
        }
        
        return min;
    }
}