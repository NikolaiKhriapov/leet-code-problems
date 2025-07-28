class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (nums.length <= 1 || k <= 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        int left = 0;
        int right = left;

        while (right < nums.length) {
            if (!set.add(nums[right++])) {
                return true;
            }
            if (right - left > k) {
                set.remove(nums[left++]);
            }
        }

        return false;        
    }
}

// time. O(n)
// space O(min(n, k + 1);