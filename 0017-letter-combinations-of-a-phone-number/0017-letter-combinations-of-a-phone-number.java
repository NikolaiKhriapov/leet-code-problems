class Solution {
    private static final String[] LETTERS = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        addLetterCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void addLetterCombinations(String digits, int i, StringBuilder curr, List<String> result) {
        if (i >= digits.length()) {
            result.add(curr.toString());
            return;
        }

        int index = curr.length();
        for (char letter : LETTERS[digits.charAt(i) - '0'].toCharArray()) {
            curr.append(letter);
            addLetterCombinations(digits, i + 1, curr, result);
            curr.delete(index, curr.length());
        }
    }
}