class Solution {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        
        int length = nums.length;
        int result1 = nums[length - 3] * nums[length - 2] * nums[length - 1];
        int result2 = nums[0] * nums[1] * nums[length - 1];

        return result1 > result2 ? result1 : result2;
    }
}
