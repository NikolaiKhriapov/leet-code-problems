class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > list.get(list.size() - 1)) {
                list.add(num);
            } else {
                int index = binarySearch(list, num);
                // int index = Collections.binarySearch(list, num);
                // if (index < 0) {
                //     index = -index - 1;
                // }
                list.set(index, num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}