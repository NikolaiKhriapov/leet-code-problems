class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int currentPositive = nums[0];
        int currentNegative = nums[0];
        int maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentPositive;
                currentPositive = currentNegative;
                currentNegative = temp;
            }
            currentPositive = Math.max(nums[i], currentPositive * nums[i]);
            currentNegative = Math.min(nums[i], currentNegative * nums[i]);
            maxProduct = Math.max(maxProduct, currentPositive);
        }
        
        return maxProduct;
    }
}

// time  - O(n)
// space - O(1)