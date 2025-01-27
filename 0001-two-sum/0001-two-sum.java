class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] numsS = new int[nums.length];
        for (int i = 0; i < numsS.length; i++) {
            numsS[i] = nums[i];
        }

        Arrays.sort(numsS);

        int l = 0;
        int r = numsS.length - 1;

        while (l < r) {
            if (numsS[l] + numsS[r] == target) {
                int first = -1;
                int second = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (first == -1 && nums[i] == numsS[l]) {
                        first = i;
                        nums[i] = -1;
                    }
                    if (second == -1 && nums[i] == numsS[r]) {
                        second = i;
                        nums[i] = -1;
                    }
                }
                return new int[] {first, second};
            } else if (numsS[l] + numsS[r] < target) {
                l += 1;
            } else {
                r -= 1;
            }
        }

        return new int[] {-1, -1};
    }
}