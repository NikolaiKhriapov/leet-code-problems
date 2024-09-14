class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";

        char[] arr = s.toCharArray();
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            while (vowels.indexOf(arr[p1]) == -1 && p1 < p2) {
                p1++;
            }
            while (vowels.indexOf(arr[p2]) == -1 && p1 < p2) {
                p2--;
            }

            if (p1 < p2) {     
                char temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                p1++;
                p2--;
            }
        }
        
        return new String(arr);
    }
}