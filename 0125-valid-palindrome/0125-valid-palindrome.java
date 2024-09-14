class Solution {
    public boolean isPalindrome(String s) {
        char[] sChars = s.toCharArray();
        List<Character> list = new ArrayList<>();

        for (char sChar : sChars) {
            if (Character.isLetterOrDigit(sChar)) {
                list.add(Character.toLowerCase(sChar));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != list.get(list.size() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}