class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);

        int p = nums.length - 2;
        int count = 1;
        while (p >= 0) {
            if (nums[p] != nums[p + 1]) {
                count++;
            }
            if (count == 3) {
                return nums[p];
            }
            p--;
        }

        return nums[nums.length - 1];
    }
}
