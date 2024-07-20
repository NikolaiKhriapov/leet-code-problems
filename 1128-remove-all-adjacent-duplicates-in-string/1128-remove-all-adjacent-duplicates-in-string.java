class Solution {
    public String removeDuplicates(String s) {

        char[] arr = s.toCharArray();

        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (p != 0 && arr[p - 1] == c) p--;
            else {
                arr[p++] = c;
            }
        }
        
        return new String(arr, 0, p);
    }
}