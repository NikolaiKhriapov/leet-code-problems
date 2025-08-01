class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}

// time  - O(n)
// space - O(n)