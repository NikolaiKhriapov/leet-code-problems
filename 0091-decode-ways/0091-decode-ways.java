class Solution {
    public int numDecodings(String s) {
        if (s == null || s.startsWith("0")) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }

        return numDecodings(s, 0, new HashMap<>());
    }

    private static int numDecodings(String s, int idx, Map<Integer, Integer> memo) {
        if (idx >= s.length()) {
            return 1;
        }

        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        int count = 0;

        if (s.charAt(idx) - '0' == 0) {
            memo.put(idx, count);
            return count;
        }

        int one = numDecodings(s, idx + 1, memo);
        count += one;

        if (idx + 2 <= s.length() && Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
            int two = numDecodings(s, idx + 2, memo);
            count += two;
        }

        memo.put(idx, count);

        return count;
    }
}