class Solution {
    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();

        String vowels = "aeiouAEIOU";
        
        int pl = 0;
        int pr = s.length() - 1;

        while (pl < pr) {
            while (pl < pr && vowels.indexOf(sArr[pl]) == -1) {
                pl++;
            }
            while (pl < pr && vowels.indexOf(sArr[pr]) == -1) {
                pr--;
            }
            if (pl < pr) {
                char temp = sArr[pl];
                sArr[pl] = sArr[pr];
                sArr[pr] = temp;
            }
            pl++;
            pr--;
        }

        return new String(sArr);
    }
}