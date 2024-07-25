class Solution {
    public void moveZeroes(int[] nums) {

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && counter <= nums.length) {
                for (int j = i + 1; j < nums.length; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                i--;
                counter++;
            }
        }
    }
}