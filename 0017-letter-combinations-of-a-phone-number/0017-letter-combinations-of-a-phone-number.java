class Solution {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        addLetterToCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void addLetterToCombinations(String digits, int index, StringBuilder curr, List<String> result) {
        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for (char c : LETTERS[digit].toCharArray()) {
            curr.append(c);
            addLetterToCombinations(digits, index + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}