class Solution {
    public int specialArray(int[] nums) {
        int l = nums.length;
        int[] array = new int[l + 1];

        for (int n : nums) {
            if (n >= l) array[l]++;
            else array[n]++;
        }

        int count = 0;
        for (int i = l; i >= 0; i--) {
            count += array[i];
            if (count == i) return i;
        }

        return -1;
    }
}