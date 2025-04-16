class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] > 0) continue;

            int product = nums[i];
            maxProduct = Math.max(maxProduct, product);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == 0) break;
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
}