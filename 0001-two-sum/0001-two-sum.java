class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] arraySorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arraySorted);

        int l = 0;
        int r = arraySorted.length - 1;

        while (l < r) {
            if (arraySorted[l] + arraySorted[r] == target) {
                int first = -1;
                int second = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (first == -1 && nums[i] == arraySorted[l]) {
                        first = i;
                        nums[i] = -1;
                    }
                    if (second == -1 && nums[i] == arraySorted[r]) {
                        second = i;
                        nums[i] = -1;
                    }
                }
                return new int[] {first, second};
            } else if (arraySorted[l] + arraySorted[r] < target) {
                l += 1;
            } else {
                r -= 1;
            }
        }

        return new int[] {-1, -1};
    }
}