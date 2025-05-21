class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length < 3) {
            return false;
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
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