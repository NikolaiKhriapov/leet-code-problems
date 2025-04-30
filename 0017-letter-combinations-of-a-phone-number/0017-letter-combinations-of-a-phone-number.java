class Solution {
    private final static String[] DIGIT_TO_LETTERS_MAP = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list = addDigitToList(list, digits.charAt(i) - '0');
        }
        return list;
    }

    private List<String> addDigitToList(List<String> list, int digit) {
        List<String> result = new ArrayList<>();

        if (list.isEmpty()) {
            for (char c : DIGIT_TO_LETTERS_MAP[digit].toCharArray()) {
                result.add(String.valueOf(c));
            }
        } else {
            for (String curr : list) {
                for (char c : DIGIT_TO_LETTERS_MAP[digit].toCharArray()) {
                    result.add(curr + c);
                }
            }
        }
        return result;
    }
}