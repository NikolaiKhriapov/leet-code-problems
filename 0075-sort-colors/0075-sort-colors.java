class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int pl = 0;
        int pr = nums.length - 1;

        for (int i = 0; i <= pr; i++) {
            if (nums[i] == 0) {
                swap(nums, i, pl);
                pl++;
            } else if (nums[i] == 2) {
                swap(nums, i, pr);
                pr--;
                i--;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}