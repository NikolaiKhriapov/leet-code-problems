class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] array = new int[10001];

        for (int n : nums) {
            array[n]++;
        }

        int dupl = -1;
        int miss = -1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != 1) {
                if (array[i] == 0) {
                    miss = i;
                } else if (array[i] == 2) {
                    dupl = i;
                }
                if (miss != -1 && dupl != -1) {
                    return new int[] {dupl, miss};
                }
            }
        }

        return new int[] {-1, -1};
    }
}