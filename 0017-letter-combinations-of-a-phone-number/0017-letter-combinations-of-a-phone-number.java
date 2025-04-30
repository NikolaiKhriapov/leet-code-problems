class Solution {
    private final static String[] DIGIT_TO_LETTERS_MAP = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<String> list = new ArrayList<>();
        
        // add first letters
        int firstDigit = digits.charAt(0) - '0';
        for (char c : DIGIT_TO_LETTERS_MAP[firstDigit].toCharArray()) {
            list.add(String.valueOf(c));
        }

        // add other letters
        for (int i = 1; i < digits.length(); i++) {
            list = addDigitToList(list, digits.charAt(i) - '0');
        }

        return list;
    }

    private List<String> addDigitToList(List<String> list, int digit) {
        List<String> result = new ArrayList<>();

        for (String curr : list) {
            for (char c : DIGIT_TO_LETTERS_MAP[digit].toCharArray()) {
                result.add(curr + c);
            }
        }
        return result;
    }
}