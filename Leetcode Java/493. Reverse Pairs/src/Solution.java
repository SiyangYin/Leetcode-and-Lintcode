import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    int[] tr;
    int n;
    
    int lowbit(int x) {
        return x & -x;
    }
    
    void add(int k, int x) {
        for (; k <= n; k += lowbit(k)) {
            tr[k] += x;
        }
    }
    
    int sum(int k) {
        int res = 0;
        for (; k > 0; k -= lowbit(k)) {
            res += tr[k];
        }
        return res;
    }
    
    public int reversePairs(int[] A) {
        long[] tmp = new long[A.length << 1];
        for (int i = 0; i < A.length; i++) {
            tmp[2 * i] = A[i];
            tmp[2 * i + 1] = A[i] * 2L;
        }
        
        Arrays.sort(tmp);
        int m = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (m == 0 || tmp[i] > tmp[m - 1]) {
                tmp[m++] = tmp[i];
            }
        }
        
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(tmp[i], i + 1);
        }
        
        n = m;
        tr = new int[m + 1];
        
        int res = 0;
        for (int i = 0, x; i < A.length; i++) {
            x = A[i];
            res += i - sum(map.get(x * 2L));
            add(map.get((long) x), 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
