class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int right = binarySearch(numbers, complement, i + 1, numbers.length - 1);
            if (right != -1) {
                return new int[] {i + 1, right + 1};
            }
        }
        
        throw new IllegalArgumentException("Invalid input");
    }

    private int binarySearch(int[] numbers, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int mid = left + (right - left) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] > target) {
            return binarySearch(numbers, target, left, mid - 1);
        }
        return binarySearch(numbers, target, mid + 1, right);
    }

}

// time  - O(n log n)
// space - O(1)