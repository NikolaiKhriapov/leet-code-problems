class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            int a = columnNumber % 26;
            if (a >= 26) {
                sb.append("Z");
            } else {
                sb.append((char) (a + 'A'));
            }
            columnNumber /= 26;
        }
        
        return sb.reverse().toString();
    }
}