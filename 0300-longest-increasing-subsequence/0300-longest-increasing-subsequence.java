class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input"); // for simplicity
        }
        if (nums.length <= 1) {
            return nums.length;
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int largest = list.get(list.size() - 1);
            if (n > largest) {
                list.add(n);
            } else {
                // int index = findPosition(list, n, 0, list.size() - 1);
                int index = Collections.binarySearch(list, n);
                if (index < 0) {
                    index = -index - 1;
                }
                list.set(index, n);
            }
        }
        return list.size();
    }

    private int findPosition(List<Integer> list, int target, int left, int right) {
        if (left > right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (target == list.get(mid)) {
            return mid;
        }
        if (target < list.get(mid)) {
            if (mid == 0 || target > list.get(mid - 1)) {
                return mid;
            } else {
                return findPosition(list, target, left, mid - 1);
            }
        }
        return findPosition(list, target, mid + 1, right);
    }
}
