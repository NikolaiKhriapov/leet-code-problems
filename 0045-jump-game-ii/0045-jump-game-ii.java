class Solution {
    public int jump(int[] nums) {


        int currFarthest = 0;
        int maxFarthest = 0;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxFarthest = Math.max(maxFarthest, i + nums[i]);
            if (i == currFarthest) {
                count++;
                currFarthest = maxFarthest;
            }
            if (currFarthest >= nums.length) {
                break;
            }
        }
        return count;
    }
}