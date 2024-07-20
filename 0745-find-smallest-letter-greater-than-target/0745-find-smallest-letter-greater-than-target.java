class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return search(letters, target, 0, letters.length - 1);
    }

    public char search(char[] letters, char target, int l, int r) {
        if (l > r) return l < letters.length ? letters[l] : letters[0];

        int m = l + ((r - l) / 2);

        // if (letters[m] == target) return letters[m + 1];
        if (letters[m] > target) return search(letters, target, l, m - 1);
        else return search(letters, target, m + 1, r);
    }
}