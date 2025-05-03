class Solution {
    public int jump(int[] nums) {

        int result = 0;
        int currReachable = 0;
        int maxReachable = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == currReachable) {
                result++;
                currReachable = maxReachable;
            }
        }
        return result;
    }
}