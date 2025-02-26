class Solution {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 0;
        int pl = 0;
        int pr = 1;
        
        while (pr < nums.length) {
            int diff = nums[pr] - nums[pl];
            
            if (diff == 0) {
                pr++;
            } else if (diff == 1) {
                max = Math.max(max, pr - pl + 1);
                pr++;
            } else {
                pl++;
            }
        }
        
        return max;
    }
}