class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        for (int i = columnTitle.length() - 1; i >= 0; i--) {           
            result += Math.pow(26, (columnTitle.length() - 1 - i)) * (columnTitle.charAt(i) - 'A' + 1);
        }

        return result;
    }
}