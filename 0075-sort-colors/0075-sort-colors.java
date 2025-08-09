class Solution {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length == 1) {
            return;
        }

        int p0 = 0;
        int p1 = 0;
        int p2 = nums.length - 1;
        
        while (p1 <= p2) {
            if (nums[p1] == 0) {
                swap(nums, p0, p1);
                p0++;
            } else if (nums[p1] == 2) {
                swap(nums, p1, p2);
                p2--;
            } else {
                p1++;
            }
            if (p0 > p1) {
                p1 = p0;
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

// [2,1]
//  ---

// time  - O(n)
// space - O(1)