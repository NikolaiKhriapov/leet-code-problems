class Solution {
    private static final int[] NUMBERS = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] LETTERS = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < NUMBERS.length; i++) {
            while (num >= NUMBERS[i]) {
                result.append(LETTERS[i]);
                num -= NUMBERS[i];
            }
        }
        return result.toString();
    }
}