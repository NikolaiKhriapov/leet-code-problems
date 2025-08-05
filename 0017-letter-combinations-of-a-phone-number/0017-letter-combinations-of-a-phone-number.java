class Solution {
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
        for (char letter : getLetters(digit).toCharArray()) {
            curr.append(letter);
            addLetter(digits, index + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    private static String getLetters(char digit) {
        return switch (digit) {
            case '2' -> "abc";
            case '3' -> "def";
            case '4' -> "ghi";
            case '5' -> "jkl";
            case '6' -> "mno";
            case '7' -> "pqrs";
            case '8' -> "tuv";
            case '9' -> "wxyz";
            default -> throw new IllegalArgumentException("Invalid input");
        };
    }
}

// time  - O(3^n)
// space - O(3^n)