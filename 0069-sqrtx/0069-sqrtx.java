class Solution {
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        long result = 0;
        for (long i = result + 1; i * i <= x; i++) {
            result = i;
        }
        return (int) result;
    }
}

// time  - O(n)
// space - O(1)