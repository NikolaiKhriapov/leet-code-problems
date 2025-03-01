class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        int sl = columnTitle.length();
        for (int i = 0; i < sl; i++) {
            int sub = columnTitle.charAt(i) - 'A' + 1;
            if (i != sl - 1) {
                sub *= Math.pow(26, (sl - 1 - i));
            }
            result += sub;
        }
        
        return result;
    }
}