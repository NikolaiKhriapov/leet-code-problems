class Solution {
    private static final String OPENED = "(";
    private static final String CLOSED = ")";

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        addParenthesis(n, n, n, new StringBuilder(), result);
        return result;
    }

    private static void addParenthesis(int n, int openedLeft, int closedLeft, StringBuilder curr, List<String> result) {
        if (openedLeft <= 0 && closedLeft <= 0) {
            result.add(curr.toString());
            return;
        }

        int index = curr.length();
        if (openedLeft > 0) {
            curr.append(OPENED);
            addParenthesis(n, openedLeft - 1, closedLeft, curr, result);
            curr.delete(index, curr.length());
        }
        if (closedLeft > 0 && closedLeft > openedLeft) {
            curr.append(CLOSED);
            addParenthesis(n, openedLeft, closedLeft - 1, curr, result);
            curr.delete(index, curr.length());
        }
    }
}