class NumArray {
    int[] preSums;

    public NumArray(int[] nums) {
        this.preSums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            preSums[i + 1] = preSums[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSums[right + 1] - preSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */