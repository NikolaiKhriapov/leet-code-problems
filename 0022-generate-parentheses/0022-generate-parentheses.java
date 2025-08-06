class Solution {
    public List<String> generateParenthesis(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        List<String> result = new ArrayList<>();
        helper(n, n, new StringBuilder(), result);
        return result;
    }

    private void helper(int openingCount, int closingCount, StringBuilder curr, List<String> result) {
        if (closingCount == 0) {
            result.add(curr.toString());
            return;
        }

        int currLength = curr.length();

        if (openingCount < closingCount && closingCount > 0) {
            curr.append(")");
            helper(openingCount, closingCount - 1, curr, result);
            curr.setLength(currLength);
        }

        if (openingCount > 0) {
            curr.append("(");
            helper(openingCount - 1, closingCount, curr, result);
            curr.setLength(currLength);
        }
    }
}

// time  - O(2^n)
// space - O(2^n)