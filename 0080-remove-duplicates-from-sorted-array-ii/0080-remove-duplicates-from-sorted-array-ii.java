class Solution {
    private static final int MAX_FREQUENCY = 2;

    public int removeDuplicates(int[] nums) {
        if (nums.length <= MAX_FREQUENCY) {
            return nums.length;
        }
        
        int left = MAX_FREQUENCY;
        for (int i = MAX_FREQUENCY; i < nums.length; i++) {
            if (nums[i] != nums[left - MAX_FREQUENCY]) {
                swap(nums, i, left);
                left++;
            }
        }
        return left;
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}