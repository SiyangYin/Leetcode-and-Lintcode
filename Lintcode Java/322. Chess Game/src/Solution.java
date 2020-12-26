import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param queen:  queen‘coordinate
     * @param knight: knight‘coordinate
     * @return: if knight is attacked please return true，else return false
     */
    public boolean[] isAttacked(int[][] queen, int[][] knight) {
        // write your code here
        boolean[] res = new boolean[knight.length];
        
        Set<Integer> rows = new HashSet<>(), cols = new HashSet<>(), diffs = new HashSet<>(), sums = new HashSet<>();
        for (int[] qu : queen) {
            rows.add(qu[0]);
            cols.add(qu[1]);
            diffs.add(qu[0] - qu[1]);
            sums.add(qu[0] + qu[1]);
        }
        for (int i = 0; i < knight.length; i++) {
            int kx = knight[i][0], ky = knight[i][1];
            if (rows.contains(kx) || cols.contains(ky) || diffs.contains(kx - ky) || sums.contains(kx + ky)) {
                res[i] = true;
            }
        }
        
        return res;
    }
}
