class Solution {
    public String removeDuplicates(String s) {

        char[] arr = s.toCharArray();

        int p = 0;
        for (char c : s.toCharArray()) {
            if (p != 0 && arr[p - 1] == c) p--;
            else {
                arr[p++] = c;
            }
        }
        
        return new String(arr, 0, p);
    }
}