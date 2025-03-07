class Solution {
    public int countGoodSubstrings(String s) {
        char[] arr = s.toCharArray();
        
        if (arr.length < 3) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (isGood(arr[i], arr[i + 1], arr[i + 2])) {
                count++;
            }
        }

        return count;
    }

    private boolean isGood(char a, char b, char c) {
        return a != b && b != c && a != c;
    }
}