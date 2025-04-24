class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        Set<Integer> perfectSquareNumbers = getPerfectSquares(n);
        return numSquares(n, perfectSquareNumbers, new int[n + 1]);
    }

    private int numSquares(int n, Set<Integer> perfectSquareNumbers, int[] memo) {
        if (n < 0) return -1;
        if (n == 0) return 0;

        if (memo[n] != 0) return memo[n];

        if (perfectSquareNumbers.contains(n)) {
            memo[n] = 1;
            return 1;
        }

        int min = Integer.MAX_VALUE;
        for (int i : perfectSquareNumbers) {
            if (n - i >= 0) {
                int numSquares = numSquares(n - i, perfectSquareNumbers, memo);
                if (numSquares != -1) {
                    min = Math.min(min, numSquares);
                }
            }
        }

        int result = 1 + min;
        memo[n] = result;
        return result;
    }

    private Set<Integer> getPerfectSquares(int n) {
        Set<Integer> result = new HashSet<>();
        int nSqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= nSqrt; i++) {
            result.add(i * i);
        }
        return result;
    }


}