import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    long res;
    
    /**
     * @param s: The capacity of backpack
     * @param v: The value of goods
     * @param c: The capacity of goods
     * @return: The answer
     */
    public long getMaxValue(int s, int[] v, int[] c) {
        // Write your code here
        int n = v.length, k = n >> 1;
        List<long[]> comb1 = new ArrayList<>();
        dfs1(0, k, 0, 0, v, c, comb1, s);
        comb1.sort((x, y) -> x[0] == y[0] ? Long.compare(x[1], y[1]) : Long.compare(x[0], y[0]));
        int j = 0;
        for (int i = 0; i < comb1.size(); i++) {
            int ii = i;
            while (ii < comb1.size() && comb1.get(ii)[0] == comb1.get(i)[0]) {
                ii++;
            }
    
            long[] item = comb1.get(ii - 1);
            if (j == 0 || item[1] > comb1.get(j - 1)[1]) {
                comb1.set(j++, item);
            }
            
            i = ii - 1;
        }
        
        comb1 = comb1.subList(0, j);
        dfs2(k, n, 0, 0, v, c, comb1, s);
        return res;
    }
    
    void dfs1(int u, int k, long sv, long sc, int[] v, int[] c, List<long[]> comb1, int s) {
        if (u == k) {
            comb1.add(new long[]{sc, sv});
            return;
        }
        
        dfs1(u + 1, k, sv, sc, v, c, comb1, s);
        if (sc + c[u] <= s) {
            dfs1(u + 1, k, sv + v[u], sc + c[u], v, c, comb1, s);
        }
    }
    
    void dfs2(int u, int n, long sv, long sc, int[] v, int[] c, List<long[]> comb1, int s) {
        if (u == n) {
            int l = 0, r = comb1.size() - 1;
            while (l < r) {
                int mid = l + (r - l + 1 >> 1);
                if (comb1.get(mid)[0] + sc <= s) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            res = Math.max(res, comb1.get(l)[1] + sv);
            
            return;
        }
        
        dfs2(u + 1, n, sv, sc, v, c, comb1, s);
        if (sc + c[u] <= s) {
            dfs2(u + 1, n, sv + v[u], sc + c[u], v, c, comb1, s);
        }
    }
    
    public static void main(String[] args) {
        System.out.println((long) (1e13));
        System.out.println(Integer.MAX_VALUE);
    }
}