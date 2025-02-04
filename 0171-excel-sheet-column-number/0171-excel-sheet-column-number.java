class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        int columnTitleLength = columnTitle.length();
        for (int i = columnTitleLength - 1; i >= 0; i--) {           
            result += Math.pow(26, (columnTitleLength - 1 - i)) * (columnTitle.charAt(i) - 'A' + 1);
        }

        return result;
    }
}