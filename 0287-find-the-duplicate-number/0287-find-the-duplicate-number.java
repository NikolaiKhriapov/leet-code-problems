class Solution {
    public int findDuplicate(int[] nums) {

        int[] count = new int[nums.length + 1];
        for (int n : nums) {
            count[n]++;
            if (count[n] > 1) {
                return n;
            }
        }
        
        return -1;
    }
}