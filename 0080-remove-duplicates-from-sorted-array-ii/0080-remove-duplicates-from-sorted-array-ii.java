class Solution {
    private static final int SEQUENCE = 2;

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= SEQUENCE) {
            return nums.length;
        }
        
        int index = SEQUENCE;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > nums[index - 2]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}