public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (guess(m) == 0) {
                return m;
            }
            
            if (guess(m) == -1) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}

class GuessGame {
    private int n;
    
    public int guess(int num) {
        if (n < num) {
            return -1;
        } else if (n > num) {
            return 1;
        }
        return 0;
    }
}