class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int index = copy.length / 2 - (copy.length % 2 == 1 ? 0 : 1);
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[index--];
        }

        index = copy.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[index--];
        }
    }
}
