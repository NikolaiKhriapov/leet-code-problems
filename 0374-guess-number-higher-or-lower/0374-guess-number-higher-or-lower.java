/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return helper(n, 1, n);
    }

    private int helper(int n, int l, int r) {
        if (r < l) return l;

        int m = l + (r - l) / 2;
        int guess = guess(m);

        if (guess == 0) return m;
        if (guess < 0) return helper(n, l, m - 1);
        return helper(n, m + 1, r);
    }
}