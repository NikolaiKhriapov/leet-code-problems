class Solution {
    private static final Map<Character, String> KEYS = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        addLetter(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void addLetter(String digits, int index, StringBuilder curr, List<String> result) {
        if (index == digits.length()) {
            result.add(curr.toString());
            return;
        }

        char digit = digits.charAt(index);
        for (char letter : KEYS.getOrDefault(digit, "").toCharArray()) {
            curr.append(letter);
            addLetter(digits, index + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}

// time  - O(4^n)
// space - O(4^n)