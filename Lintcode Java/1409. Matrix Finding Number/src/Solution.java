import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {
    /**
     * @param mat: The matrix
     * @return: The answer
     */
    public int findingNumber(int[][] mat) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        for (int i : mat[0]) {
            set.add(i);
        }
    
        Set<Integer> cur = new HashSet<>();
        for (int i = 1; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (set.contains(mat[i][j])) {
                    cur.add(mat[i][j]);
                }
            }
            
            set = cur;
            cur = new HashSet<>();
        }
        
        int res = Integer.MAX_VALUE;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int num = it.next();
            res = Math.min(res, num);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},{3, 4, 2},{2, 1, 3}};
        System.out.println(new Solution().findingNumber(mat));
    }
}
