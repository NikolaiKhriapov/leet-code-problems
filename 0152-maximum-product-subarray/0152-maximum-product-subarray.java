class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int currMaxProduct = nums[0];
        int currMinProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currMaxProduct;
                currMaxProduct = currMinProduct;
                currMinProduct = temp;
            }

            currMaxProduct = Math.max(nums[i], currMaxProduct * nums[i]);
            currMinProduct = Math.min(nums[i], currMinProduct * nums[i]);

            result = Math.max(result, currMaxProduct);
        }

        return result;
    }
}