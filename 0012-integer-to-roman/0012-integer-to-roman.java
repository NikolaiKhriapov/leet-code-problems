class Solution {
    private static final int[] INTEGERS =  {1000,  900, 500,  400, 100,   90,  50,   40,  10,    9,   5,    4,   1};
    private static final String[] ROMANS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < INTEGERS.length; i++) {
            while (num >= INTEGERS[i]) {
                num -= INTEGERS[i];
                result.append(ROMANS[i]);
            }
        }
        return result.toString();
    }
}