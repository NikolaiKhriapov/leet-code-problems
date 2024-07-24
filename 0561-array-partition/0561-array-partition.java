class Solution {
    public int arrayPairSum(int[] nums) {
        
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                sum += nums[nums.length - 1 - i];
            }
        }

        return sum;
    }
}
