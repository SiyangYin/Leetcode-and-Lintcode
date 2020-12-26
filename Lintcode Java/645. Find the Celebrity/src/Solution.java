public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
    
        for (int i = 0; i < n; i++) {
            if (res != i && knows(res, i)) {
                return -1;
            }
            if (res != i && !knows(i, res)) {
                return -1;
            }
        }
        
        return res;
    }
}

class Relation {
    boolean knows(int a, int b) {
        return false;
    }
}