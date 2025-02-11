class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] *= -1;
                k--;
            } else {
                break;
            }
        }

        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] *= -1;
        }

        return calculateSum(nums);
    }

    private int calculateSum(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result += n;
        }
        return result;
    }
}