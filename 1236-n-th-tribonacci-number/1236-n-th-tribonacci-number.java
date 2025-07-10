class Solution {
    public int tribonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }        
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int prevThird = 0;
        int prevSecond = 1;
        int prevFirst = 1;

        for (int i = 3; i <= n; i++) {
            int curr = prevThird + prevSecond + prevFirst;
            prevThird = prevSecond;
            prevSecond = prevFirst;
            prevFirst = curr;
        }

        return prevFirst;
    }
}