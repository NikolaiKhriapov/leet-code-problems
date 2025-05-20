class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int prod = 1;
        for (int i = 1; i < result.length; i++) {
            prod *= nums[i - 1];
            result[i] *= prod;
        }
        
        prod = 1;
        for (int i = result.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            result[i] *= prod;
        }

        return result;
    }
}

// [1,2,3,4]
// [1,1,2,6]
// [24,12,8,6]