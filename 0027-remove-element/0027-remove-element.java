class Solution {
    public int removeElement(int[] nums, int val) {
        
        int lastIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[lastIndex] = nums[i];
                lastIndex++;
            }
        }

        for (int i = lastIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        return lastIndex;
    }
}