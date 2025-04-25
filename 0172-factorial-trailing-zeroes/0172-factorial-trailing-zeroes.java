class Solution {
    public int trailingZeroes(int n) {
        // 100! -> 100 / 5 = 20
        //          20 / 5 = 4
        //           4 / 5 = 0
        // 20 + 4 + 0 = 24;

        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
