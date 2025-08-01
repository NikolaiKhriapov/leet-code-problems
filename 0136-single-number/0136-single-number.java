class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}

// time. - O(n)
// space - O(1)

// 0100
// 0001
// ----
// 0101
// 0010
// ----
// 0111
// 0001
// ----
// 0110
// 0010
// ----
// 0100