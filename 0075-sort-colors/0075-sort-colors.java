class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int p0 = 0;
        int p1 = p0;
        int p2 = nums.length - 1;
        
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
                p1++;
            } else if (nums[p1] == 1) {
                p1++;
            } else {
                swap(nums, p1, p2);
                p2--;
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
