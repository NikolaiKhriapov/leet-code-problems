class Solution {
    public String reverseVowels(String s) {
        char[] sArr = s.toCharArray();
        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int pl = 0;
        int pr = s.length() - 1;
        
        while (pl < pr) {
            while (pl < pr && !set.contains(sArr[pl])) {
                pl++;
            }
            while (pl < pr && !set.contains(sArr[pr])) {
                pr--;
            }

            if (pl < pr) {
                char temp = sArr[pl];
                sArr[pl] = sArr[pr];
                sArr[pr] = temp;
                pl++;
                pr--;
            }
        }

        return new String(sArr);
    }
}