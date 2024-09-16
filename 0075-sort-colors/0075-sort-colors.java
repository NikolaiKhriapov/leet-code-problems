class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int r = nums.length - 1;

        while (m <= r) {
            if (nums[m] == 0) {
                int temp = nums[l];
                nums[l] = nums[m];
                nums[m] = temp;
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else if (nums[m] == 2) {
                int temp = nums[m];
                nums[m] = nums[r];
                nums[r] = temp;
                r--;
                // m++;
            }
        }
    }
}