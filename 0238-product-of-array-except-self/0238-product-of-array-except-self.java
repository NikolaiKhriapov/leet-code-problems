class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        
        int runningProduct = nums[0];
        for (int i = 1; i < result.length; i++) {
            result[i] *= runningProduct;
            runningProduct *= nums[i];
        }

        runningProduct = nums[nums.length - 1];
        for (int i = result.length - 2; i >= 0; i--) {
            result[i] *= runningProduct;
            runningProduct *= nums[i];
        }

        return result;
    }
}

// time  - O(n)
// space - O(n)