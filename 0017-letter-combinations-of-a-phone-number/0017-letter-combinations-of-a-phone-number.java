class Solution {
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : digits.toCharArray()) {
            result = addDigitToCombinations(c - '0', result);
        }
        
        return result;
    }

    private List<String> addDigitToCombinations(int digit, List<String> result) {
        List<String> list = new ArrayList<>();
        for (String str : result) {
            for (char c : LETTERS[digit].toCharArray()) {
                list.add(str + c);
            }
        }
        return list;
    }
}