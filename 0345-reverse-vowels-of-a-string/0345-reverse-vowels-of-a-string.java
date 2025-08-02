class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        char[] sArray = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isVowel(sArray[left])) {
                left++;
            }
            while (left < right && !isVowel(sArray[right])) {
                right--;
            }
            if (left < right) {
                char temp = sArray[left];
                sArray[left] = sArray[right];
                sArray[right] = temp;
            }
            left++;
            right--;
        }

        return new String(sArray);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}

// time. - O(n)
// space - O(n)