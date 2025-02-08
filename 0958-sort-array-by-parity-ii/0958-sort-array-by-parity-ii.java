class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] array = new int[nums.length];

        int pe = 0;
        int po = 1;

        for (int i = 0; i < nums.length; i++) {
            if (isEven(nums[i])) {
                array[pe] = nums[i];
                pe += 2;
            } else {
                array[po] = nums[i];
                po += 2;
            }
        }
        
        return array;
    }

    private boolean isEven(int n) {
        return n % 2 == 0;
    }
}