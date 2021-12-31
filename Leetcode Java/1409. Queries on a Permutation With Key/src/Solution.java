import java.util.Arrays;

public class Solution {
    
    int[] tr;
    
    int sum(int k) {
        int res = 0;
        for (int i = k; i > 0; i -= Integer.lowestOneBit(i)) {
            res += tr[i];
        }
        
        return res;
    }
    
    void add(int k, int x) {
        for (int i = k; i < tr.length; i += Integer.lowestOneBit(i)) {
            tr[i] += x;
        }
    }
    
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        tr = new int[n + m + 1];
        int[] pos = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            pos[i] = i + n;
            add(pos[i], 1);
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int x = queries[i];
            res[i] = sum(pos[x] - 1);
            add(pos[x], -1);
            add(n - i, 1);
            pos[x] = n - i;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] q = {7, 5, 5, 8, 3};
        int m = 8;
        System.out.println(Arrays.toString(new Solution().processQueries(q, m)));
    }
}
