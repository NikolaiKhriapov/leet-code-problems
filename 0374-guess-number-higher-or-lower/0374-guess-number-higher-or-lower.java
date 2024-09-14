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
        return search(n, 0, n);
    }

    private int search(int n, int l, int r) {
        if (l > r) {
            return r;
        }

        int m = l + ((r - l) /2);

        int guess = guess(m);
        if (guess == 0) {
            return m;
        }
        if (guess < 0) {
            return search(n, l, m - 1);
        } else {
            return search(n, m + 1, r);
        }
    }
}