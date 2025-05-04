class Solution {
    private static final int[] INTEGERS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] LETTERS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Invalid input"); //for simplicity
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < INTEGERS.length; i++) {
            while (INTEGERS[i] <= num) {
                result.append(LETTERS[i]);
                num -= INTEGERS[i];
            }
        }
        return result.toString();
    }
}