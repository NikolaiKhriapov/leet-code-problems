class Solution {
    private static final String[] LETTERS_2 = new String[] {"a", "b", "c"};
    private static final String[] LETTERS_3 = new String[] {"d", "e", "f"};
    private static final String[] LETTERS_4 = new String[] {"g", "h", "i"};
    private static final String[] LETTERS_5 = new String[] {"j", "k", "l"};
    private static final String[] LETTERS_6 = new String[] {"m", "n", "o"};
    private static final String[] LETTERS_7 = new String[] {"p", "q", "r", "s"};
    private static final String[] LETTERS_8 = new String[] {"t", "u", "v"};
    private static final String[] LETTERS_9 = new String[] {"w", "x", "y", "z"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        helper(digits, 0, "", result);
        return result;
    }

    private static void helper(String digits, int i, String curr, List<String> result) {
        if (i >= digits.length()) {
            result.add(curr);
            return;
        }

        String[] letters = getLettersForDigit(digits.charAt(i));

        int index = curr.length();
        for (String letter : letters) {
            curr += letter;
            helper(digits, i + 1, curr, result);
            curr = curr.substring(0, index);
        }
    }

    private static String[] getLettersForDigit(char c) {
        return switch (c) {
            case '2' -> LETTERS_2;
            case '3' -> LETTERS_3;
            case '4' -> LETTERS_4;
            case '5' -> LETTERS_5;
            case '6' -> LETTERS_6;
            case '7' -> LETTERS_7;
            case '8' -> LETTERS_8;
            case '9' -> LETTERS_9;
            default -> throw new RuntimeException("Invalid number: " + c);
        };
    }
}