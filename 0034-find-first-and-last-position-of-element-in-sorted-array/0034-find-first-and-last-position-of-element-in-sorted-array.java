class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearchLeft(nums, target, 0, nums.length - 1);
        int r = binarySearchRight(nums, target, l, nums.length - 1);

        return new int[] { l, r };
    }

    public int binarySearchLeft(int[] nums, int target, int l, int r) {
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            if (m == 0 || nums[m - 1] < target) {
                return m;
            } else {
                return binarySearchLeft(nums, target, l, m - 1);
            }
        }

        if (nums[m] > target) {
            return binarySearchLeft(nums, target, l, m - 1);
        } else return binarySearchLeft(nums, target, m + 1, r);
    }

    public int binarySearchRight(int[] nums, int target, int l, int r) {
        if (l > r || l == -1) {
            return -1;
        }

        int m = l + (r - l) / 2;

        if (nums[m] == target) {
            if (m == nums.length - 1 || nums[m + 1] > target) {
                return m;
            } else {
                return binarySearchRight(nums, target, m + 1, r);
            }
        }

        if (nums[m] > target) {
            return binarySearchRight(nums, target, l, m - 1);
        } else {
            return binarySearchRight(nums, target, m + 1, r);
        }
    }
}