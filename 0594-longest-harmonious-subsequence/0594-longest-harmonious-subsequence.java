class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int maxDiff = 0;
        int p1 = 0;
        int p2 = 1;

        while (p2 < nums.length) {
            int diff = nums[p2] - nums[p1];
            if (diff == 1) {
                maxDiff = Math.max(maxDiff, p2 - p1 + 1);
                p2++;
            } else if (diff > 1) {
                p1++;
            } else {
                p2++;
            }
        }

        return maxDiff;
    }
}
