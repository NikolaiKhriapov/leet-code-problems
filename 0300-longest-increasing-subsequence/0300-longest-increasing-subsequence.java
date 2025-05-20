class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                // int insertionIndex = Collections.binarySearch(list, nums[i]);
                int insertionIndex = getInsertionIndex(list, nums[i]);
                // if (insertionIndex < 0) {
                //     insertionIndex = -insertionIndex - 1;
                // }
                list.set(insertionIndex, nums[i]);
            }
        }
        return list.size();
    }

    private int getInsertionIndex(List<Integer> list, int n) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

// 2,3,7,101