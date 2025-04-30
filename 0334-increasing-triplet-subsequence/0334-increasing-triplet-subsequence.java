class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n < first && n > second) {
                first = n;
            } else if (n < first && n < second) {
                second = n;
            } else if (n > first) {
                return true;
            }
        }

        return false;
    }
}