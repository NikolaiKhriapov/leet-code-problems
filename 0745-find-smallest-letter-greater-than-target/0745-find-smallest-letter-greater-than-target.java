class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return binarySearch(letters, target, 0, letters.length - 1);
    }

    public char binarySearch(char[] letters, char target, int l, int r) {
        if (r < l) return l < letters.length ? letters[l] : letters[0];

        int m = l + (r - l) / 2;

        if (letters[m] > target) {
            return binarySearch(letters, target, l, m - 1);
        } else {
            return binarySearch(letters, target, m + 1, r);
        }
    }
}