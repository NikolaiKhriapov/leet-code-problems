class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            
            boolean isAdded = set.add(nums[i]);
            if (!isAdded) {
                return true;
            }
        }
        
        return false;
    }
}