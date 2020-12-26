public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return guess(l) == 0 ? l : r;
    }
}

class GuessGame {
    int guess(int num) {
        return 0;
    }
}