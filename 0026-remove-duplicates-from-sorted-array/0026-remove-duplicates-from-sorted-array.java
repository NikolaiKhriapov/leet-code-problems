class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int l = 0;
        int r = 1;

        while (r < nums.length) {
            if (nums[r] == nums[l]) {
                r++;
            } else {
                l++;
                nums[l] = nums[r];
            }
        }

        int res = l + 1;

        for (int i = l + 1; i < nums.length; i++) {
            nums[i] = 0;
        }

        return res;
    }
}