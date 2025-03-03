class Solution {
    public int romanToInt(String s) {
        char[] sArr = s.toCharArray();

        int result = 0;
        int prev = 0;
        for (int i = sArr.length - 1; i >= 0; i--) {
            int curr = helper(sArr[i]);
            if (i != sArr.length - 1 && curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }
        
        return result;
    }

    private int helper(char c) {
        return switch(c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}