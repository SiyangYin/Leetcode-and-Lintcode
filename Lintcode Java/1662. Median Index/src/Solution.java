import java.util.Arrays;

public class Solution {
    
    class Pair {
        int val, idx;
        
        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    /**
     * @param A: the array a
     * @return: return the index of median
     */
    public int getAns(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        Pair[] pairs = new Pair[A.length];
        for (int i = 0; i < A.length; i++) {
            pairs[i] = new Pair(A[i], i);
        }
        
        Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1.val, p2.val));
        
        if (A.length % 2 != 0) {
            return pairs[A.length / 2].idx;
        } else {
            return pairs[A.length / 2 - 1].idx;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getAns(new int[]{7, 9, 4, 5, 6}));
        System.out.println(new Solution().getAns(new int[]{7, 9, 4, 5}));
        
    }
}