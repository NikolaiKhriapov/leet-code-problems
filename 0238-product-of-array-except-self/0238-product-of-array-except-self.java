class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[nums.length];
        result[0] = 1;

        int product = 1;
        for (int i = 1; i < result.length; i++) {
            product *= nums[i - 1];
            result[i] = product;
        }
        
        product = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            result[i] *= product;
        }

        return result;
    }
}

// [1,2,3,4]
// [1,1,2,6]
// [24,12,8,6]