class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        // sort
        Arrays.sort(nums);

        // 1 fixed pointer from the left, 1 pointer from the left, 1 pointer from the right
        int p1 = 0;
        int p2 = 1;
        int p3 = nums.length - 1;

        // if sum is <0 move left pointers, if >0 shift right pointer, skipping values
        while (p1 < nums.length - 2) {
            while (p2 < p3) {
                int sum = nums[p1] + nums[p2] + nums[p3];
                if (sum == 0) {
                    result.add(List.of(nums[p1], nums[p2], nums[p3]));
                    do {
                        p2++;
                    } while (p2 < p3 && nums[p2] == nums[p2 - 1]);
                } else if (sum < 0) {
                    do {
                        p2++;
                    } while (p2 < p3 && nums[p2] == nums[p2 - 1]);
                } else {
                    do {
                        p3--;
                    } while (p2 < p3 && nums[p3] == nums[p3 + 1]);
                }
            }
            do {
                p1++;
            } while (p1 < nums.length - 2 && nums[p1] == nums[p1 - 1]);
            p2 = p1 + 1;
            p3 = nums.length - 1;
        }

        return result;
    }
}