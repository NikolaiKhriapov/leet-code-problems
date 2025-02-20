class Solution {
    public int longestPalindrome(String s) {
        int[] array = new int[257];

        for (char c : s.toCharArray()) {
            array[c]++;
        }

        int result = 0;

        boolean isOneAdded = false;
        for (int n : array) {
            if (n != 0) {
                if (n % 2 == 0) {
                    result += n;
                } else {
                    if (!isOneAdded) {
                        result += n;
                        isOneAdded = true;
                    } else {
                        result += n - 1;
                    }
                }
            }
        }
        
        return result;
    }
}