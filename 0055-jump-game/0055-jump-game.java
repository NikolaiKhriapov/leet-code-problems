class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        return canJump(nums, 0, new boolean[nums.length]);
    }

    private boolean canJump(int[] nums, int index, boolean[] visited) {
        if (index >= nums.length - 1) {
            return true;
        }

        if (visited[index]) {
            return false;
        }

        for (int i = 1; i <= nums[index]; i++) {
            if (canJump(nums, index + i, visited)) {
                return true;
            }
        }
        
        visited[index] = true;
        return false;
    }
}