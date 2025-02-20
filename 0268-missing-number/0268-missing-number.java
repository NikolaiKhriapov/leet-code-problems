class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;

        int sumExpected = length * (length + 1) / 2;

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        return sumExpected - sum;
    }
}