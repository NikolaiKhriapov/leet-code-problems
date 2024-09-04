class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l = -1;
        int r = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (l == -1) {
                    l = i;
                }
                r = i;
            }
        }

        return new int[] { l, r };
    }
}