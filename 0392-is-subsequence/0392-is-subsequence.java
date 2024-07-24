class Solution {
    public boolean isSubsequence(String s, String t) {

        char[] tArray = t.toCharArray();

        int index = 0;

        for (char c : s.toCharArray()) {
            boolean isPresent = false;
            for (int i = index; i < tArray.length; i++) {
                index++;
                if (tArray[i] == c) {
                    isPresent = true; 
                    break;
                }
            }
            
            if (!isPresent) return false;
        }

        return true;
    }
}
