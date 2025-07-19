class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int a = 1; // i - 2
        int b = 1; // i - 1
        for (int i = 2; i <= n; i++) {
            int curr = a + b;
            a = b;
            b = curr;
        }
        return b;        
    }
}

// time  - O(n)
// space - O(1)