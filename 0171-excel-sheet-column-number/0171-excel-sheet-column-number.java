class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        int columnTitleLength = columnTitle.length();
        for (int i = columnTitleLength - 1; i >= 0; i--) {           
            result += Math.pow(26, columnTitleLength - 1 - i) * ((int) columnTitle.charAt(i) - 64);
        }

        return result;
    }
}