class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= first) {
                first = n;
            } else if (n <= second) {
                second = n;
            } else {
                return true;
            }
        }
        return false;
    }
}

// time  - O(n)
// space - O(1)