class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int result = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            result += num * Math.pow(26, columnTitle.length() - 1 - i);
        }
        return result;
    }
}

// time  - O(n)
// space - O(1)