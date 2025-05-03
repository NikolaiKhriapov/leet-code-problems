class Solution {
    private static final int[] NUMBERS = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] LETTERS = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < NUMBERS.length; i++) {
                if (NUMBERS[i] <= num) {
                    result.append(LETTERS[i]);
                    num -= NUMBERS[i];
                    break;
                }
            }
        }
        return result.toString();
    }
}