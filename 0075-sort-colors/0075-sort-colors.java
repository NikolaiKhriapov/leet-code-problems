class Solution {
    public void sortColors(int[] nums) {
        
        if (nums.length <= 1) return;

        int p0 = 0;
        int p1 = p0;
        int p2 = nums.length - 1;
        
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                swap(nums, p1, p0);
                p0++;
                p1++;
            } else if (nums[p1] == 2) {
                swap(nums, p1, p2);
                p2--;
            } else {
                p1++;
            }
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}