class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int num = nums[0];
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                num = n;
            }
            if (n == num) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}

// [2,2,1,1,1,2,2]
// 2
// 1