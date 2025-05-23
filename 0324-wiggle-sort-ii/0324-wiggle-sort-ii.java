class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int left = (nums.length + 1) / 2 - 1;
        int right = nums.length - 1;
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 0) ? sorted[left--] : sorted[right--];
        }        
    }
}