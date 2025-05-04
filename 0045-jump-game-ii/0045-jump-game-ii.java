class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }

        int count = 0;
        int currFarthest = 0;
        int maxFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxFarthest = Math.max(maxFarthest, i + nums[i]);
            if (i == currFarthest) {
                count++;
                currFarthest = maxFarthest;
            }
        }
        return count;
    }
}