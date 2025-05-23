class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= second) {
                second = num;
            } else if (num <= first) {
                first = num;
            } else {
                return true;
            }
        }
        return false;
    }
}

// a = 1
// b = Integer.MAX_VALUE