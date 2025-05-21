class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE; // 0,1
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < first && num <= second) {
                second = num;
            } else if (num <= first && num > second) {
                first = num;
            } else {
                return true;
            }
        }
        return false;
    }
}

// [2,1,5,0,4,6]
// 2, -
// 1, -
// 1, 5
// 1, 5
// 0, 4
// 0, 4, 6