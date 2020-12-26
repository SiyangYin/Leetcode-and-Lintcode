public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    count[i]--;
                    count[j]++;
                }
            }
        }
    
        for (int i = 0; i < n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}

class Relation {
    boolean knows(int a, int b) {
        return false;
    }
}