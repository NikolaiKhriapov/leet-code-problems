class Solution {
    public int specialArray(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int n : nums) {
            if (n >= nums.length) count[nums.length]++;
            else count[n]++;
        }
        
        int sum = 0;
        for (int i = nums.length; i >= 0; i--) {
            sum += count[i];
            if (sum == i) return i;
        }

        return -1;
    }
}