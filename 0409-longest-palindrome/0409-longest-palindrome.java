class Solution {
    public int longestPalindrome(String s) {

        char[] arr = s.toCharArray();

        Set<Character> set = new HashSet<>();

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                result += 2;
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }

        if (!set.isEmpty()) {
            result++;
        }
           
        return result;
    }
}