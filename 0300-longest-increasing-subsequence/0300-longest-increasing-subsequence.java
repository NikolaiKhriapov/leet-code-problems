class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = binarySearch(list, 0, list.size() - 1, num);
            if (index < list.size()) {
                list.set(index, num);
            } else {
                list.add(num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// time  - O(n log(n))
// space - O(n)