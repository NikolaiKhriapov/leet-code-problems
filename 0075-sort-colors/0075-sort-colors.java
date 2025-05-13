class Solution {
    public void sortColors(int[] nums) {

        int left = 0;
        int curr = left;
        int right = nums.length - 1;
        
        while (curr <= right) {
            if (nums[curr] == 0) {
                swap(nums, curr, left);
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, right);
                right--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}

// [2,0,2,1,1,0]
// [0,0,2,1,1,2]
// [0,0,1,1,2,2]
