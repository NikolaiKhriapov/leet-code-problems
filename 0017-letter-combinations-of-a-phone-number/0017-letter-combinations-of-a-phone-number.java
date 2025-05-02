class Solution {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        addDigitToCombinations(digits, 0, result, new StringBuilder());
        return result;
    }

    private void addDigitToCombinations(String digits, int index, List<String> result, StringBuilder curr) {
        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (char c : LETTERS[digit].toCharArray()) {
            curr.append(c);
            addDigitToCombinations(digits, index + 1, result, curr);
            curr.delete(index, curr.length());
        }
    }
}