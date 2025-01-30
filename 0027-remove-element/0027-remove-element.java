class Solution {
    public int removeElement(int[] nums, int val) {

        int p1 = 0;
        int p2 = 0;
        int counter = 0;
        
        while (p2 < nums.length) {
            if (nums[p2] != val) {
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                counter++;
                p1++;
            }

            p2++;
        }
        
        return counter;
    }
}