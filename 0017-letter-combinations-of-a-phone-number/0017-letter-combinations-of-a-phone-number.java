class Solution {
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
            case '2' -> new String[] {"a", "b", "c"};
            case '3' -> new String[] {"d", "e", "f"};
            case '4' -> new String[] {"g", "h", "i"};
            case '5' -> new String[] {"j", "k", "l"};
            case '6' -> new String[] {"m", "n", "o"};
            case '7' -> new String[] {"p", "q", "r", "s"};
            case '8' -> new String[] {"t", "u", "v"};
            case '9' -> new String[] {"w", "x", "y", "z"};
            default -> throw new RuntimeException("Invalid number: " + c);
        };
    }
}