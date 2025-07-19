class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long squared = (long) mid * mid;
            if (squared == x) {
                return mid;
            } else if (squared > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

// [1,2,3,4]
//.   -

// time  - O(log n)
// space - O(1)