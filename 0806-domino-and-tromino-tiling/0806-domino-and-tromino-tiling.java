class Solution {
    private static final long MODULO = 1_000_000_007L;

    public int numTilings(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = 1; // i - 3
        long b = 1; // i - 2
        long c = 2; // i - 1
        long presum = 0;

        for (int i = 3; i <= n; i++) {
            presum += 2 * a;
            long curr = (c + b + presum) % MODULO;
            a = b;
            b = c;
            c = curr;
        }
        
        return (int) c;
    }
}