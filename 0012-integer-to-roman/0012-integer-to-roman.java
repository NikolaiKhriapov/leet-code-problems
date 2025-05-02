class Solution {
    private final static int[] INTEGERS = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final static String[] LETTERS = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < INTEGERS.length; i++) {
            while (num >= INTEGERS[i]) {
                result.append(LETTERS[i]);
                num -= INTEGERS[i];
            }
        }
        return result.toString();
    }
}