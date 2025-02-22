class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return helper(letters, target, 0, letters.length - 1);
    }

    private char helper(char[] letters, char target, int l, int r) {
        if (l > r) return letters[r];

        int m = l + (r - l) / 2;

        if (letters[m] > target) {
            if (m == 0 || (m > 0 && letters[m - 1] <= target)) return letters[m];
            return helper(letters, target, l, m - 1);
        }
        if (m == letters.length - 1 && letters[m] <= target) return letters[0];
        return helper(letters, target, m + 1, r);
    }
}