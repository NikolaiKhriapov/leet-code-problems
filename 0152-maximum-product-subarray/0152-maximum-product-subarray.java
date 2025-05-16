class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxProduct = nums[0];
        int currMaxProduct = nums[0];
        int currMinProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currMaxProduct;
                currMaxProduct = currMinProduct;
                currMinProduct = temp;
            }
            currMaxProduct = Math.max(nums[i], nums[i] * currMaxProduct);
            currMinProduct = Math.min(nums[i], nums[i] * currMinProduct);
            maxProduct = Math.max(maxProduct, currMaxProduct);
        }
        return maxProduct;
    }
}