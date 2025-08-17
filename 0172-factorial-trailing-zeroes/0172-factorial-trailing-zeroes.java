class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}

// time  - O(log5n)
// space - O(1)

//  5! -> 1x0
// 10! -> 2x0
// 15! -> 3x0
// 20! -> 4x0
// 25! -> 6x0