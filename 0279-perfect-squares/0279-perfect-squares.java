class Solution {
    public int numSquares(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;

        List<Integer> perfectSquareNumbers = getPerfectSquares(n);
        return numSquares(n, perfectSquareNumbers, new HashMap<>());
    }

    private int numSquares(int n, List<Integer> perfectSquareNumbers, Map<Integer, Integer> memo) {
        if (n < 0) return -1;
        if (n == 0) return 0;

        if (memo.containsKey(n)) return memo.get(n);

        int min = n;
        for (int i : perfectSquareNumbers) {
            int res = numSquares(n - i, perfectSquareNumbers, memo);
            if (res != -1) {
                min = Math.min(min, res);
            }
        }

        int result = 1 + min;
        memo.put(n, result);
        return result;
    }

    private List<Integer> getPerfectSquares(int n) {
        List<Integer> result = new ArrayList<>();
        int nSqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= nSqrt; i++) {
            result.add(i * i);
        }
        return result;
    }


}