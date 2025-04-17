class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[nums.length];
        }

        int[] result = new int[nums.length];

        int product = 1;
        result[0] = product;
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i - 1];
            result[i] = product;
        }

        product = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            result[i] *= product;
        }

        return result;
    }
}