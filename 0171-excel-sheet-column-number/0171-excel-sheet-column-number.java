class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        int l = columnTitle.length();
        for (int i = 0; i < l; i++) {
            result += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, l - i - 1);
        }

        return result;
    }
}