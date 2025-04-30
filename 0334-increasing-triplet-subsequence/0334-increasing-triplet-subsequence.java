class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int prev = list.get(list.size() - 1);

            if (n > prev) {
                list.add(n);
            } else {
                int index = Collections.binarySearch(list, n);
                if (index < 0) {
                    index = -index - 1;
                }
                list.set(index, n);
            }

            if (list.size() >= 3) {
                return true;
            }
        }

        return false;
    }
}