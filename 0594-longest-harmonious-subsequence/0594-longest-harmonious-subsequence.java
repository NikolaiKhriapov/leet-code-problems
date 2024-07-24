class Solution {
    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int p1 = 0;
        int p2 = 1;

        int longest = 0;
        while (p1 < nums.length && p2 < nums.length) {
            int seq = 0;

            if (nums[p2] - nums[p1] <= 1) {
                seq = p2 - p1 + 1;
                if (nums[p2] != nums[p1] && seq > longest) {
                    longest = seq;
                }
                p2++;
            } else {
                p1++;
                p2 = p1 + 1;
            };
        }

        return longest;
    }
}