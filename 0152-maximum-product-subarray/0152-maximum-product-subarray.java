class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currentMaxProduct = nums[0];
        int currentMinProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMaxProduct;
                currentMaxProduct = currentMinProduct;
                currentMinProduct = temp;
            }

            currentMaxProduct = Math.max(nums[i], currentMaxProduct * nums[i]);
            currentMinProduct = Math.min(nums[i], currentMinProduct * nums[i]);

            result = Math.max(result, currentMaxProduct);
        }

        return result;
    }
}