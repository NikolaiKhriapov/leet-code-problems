class Solution {
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0")) {
            return 0;
        }

        return numDecodings(s, 0, new HashMap<>());
    }

    private int numDecodings(String s, int index, Map<Integer, Integer> memo) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (index == s.length()) {
            memo.put(index, 1);
            return 1;
        }

        int currentNumber = s.charAt(index) - '0';
        if (currentNumber == 0) {
            memo.put(index, 0);
            return 0;
        }

        int total = 0;
        total += numDecodings(s, index + 1, memo);
        if (index < s.length() - 1) {
            if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
                total += numDecodings(s, index + 2, memo);
            }
        }

        memo.put(index, total);
        return total;
    }
}