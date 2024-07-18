class Solution {
    public int lengthOfLastWord(String s) {

        String[] sSplitted = s.split(" ");
        String lastWord = sSplitted[sSplitted.length - 1];

        return lastWord.length();
        
    }
}