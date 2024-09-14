class Solution {
    public int dominantIndex(int[] nums) {
        int largest = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[largest]) {
                largest = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != largest && nums[i] * 2 > nums[largest]) {
                return -1;
            }
        }
        
        return largest;
    }
}