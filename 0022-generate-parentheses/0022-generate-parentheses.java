class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if (n <= 0) {
            return result;
        }

        addParenthesis(n, n, new StringBuilder(), result);
        return result;
    }

    private static void addParenthesis(int openedLeft, int closedLeft, StringBuilder curr, List<String> result) {
        if (openedLeft <= 0 && closedLeft <= 0) {
            result.add(curr.toString());
            return;
        }

        int index = curr.length();
        if (openedLeft > 0) {
            curr.append("(");
            addParenthesis(openedLeft - 1, closedLeft, curr, result);
            curr.delete(index, curr.length());
        }
        if (closedLeft > 0 && closedLeft > openedLeft) {
            curr.append(")");
            addParenthesis(openedLeft, closedLeft - 1, curr, result);
            curr.delete(index, curr.length());
        }
    }
}