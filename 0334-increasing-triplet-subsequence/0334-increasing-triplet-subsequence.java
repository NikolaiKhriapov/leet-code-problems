class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= firstMin) {
                firstMin = n;
            } else if (n <= secondMin) {
                secondMin = n;
            } else {
                return true;
            }
        }

        return false;
    }
}