class Solution {
    private static final long MODULO = 1_000_000_007L;

    public int numTilings(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = 1;
        long b = 1;
        long c = 2;

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