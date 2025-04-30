class Solution {
    private final static String[] DIGIT_TO_LETTERS_MAP = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        addLetterToCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void addLetterToCombinations(String digits, int index, StringBuilder curr, List<String> list) {
        if (index == digits.length()) {
            list.add(curr.toString());
            return;
        }
        
        int length = curr.length();
        for (char c : DIGIT_TO_LETTERS_MAP[digits.charAt(index) - '0'].toCharArray()) {
            curr.append(c);
            addLetterToCombinations(digits, index + 1, curr, list);
            curr.delete(length, curr.length());
        }
    }
}