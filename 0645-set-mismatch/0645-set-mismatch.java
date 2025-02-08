class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] array = new int[nums.length];

        for (int n : nums) {
            array[n - 1]++;
        }

        int dupl = -1;
        int miss = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 1) {
                if (array[i] == 0) {
                    miss = i + 1;
                } else if (array[i] == 2) {
                    dupl = i + 1;
                }
                if (miss != -1 && dupl != -1) {
                    return new int[] {dupl, miss};
                }
            }
        }

        return new int[] {-1, -1};
    }
}