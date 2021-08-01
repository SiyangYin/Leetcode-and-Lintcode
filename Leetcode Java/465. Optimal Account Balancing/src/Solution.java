import java.util.*;

public class Solution {
    public int minTransfers(int[][] transactions) {
        int n = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            map.putIfAbsent(tran[0], n++);
            map.putIfAbsent(tran[1], n++);
        }
        
        int[] out = new int[n];
        for (int[] trans : transactions) {
            int from = map.get(trans[0]), to = map.get(trans[1]), x = trans[2];
            out[from] += x;
            out[to] -= x;
        }
    
        List<Integer> list = new ArrayList<>();
        for (int x : out) {
            if (x != 0) {
                list.add(x);
            }
        }
    
        n = list.size();
        int[] f = new int[1 << n];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 1; i < 1 << n; i++) {
            int sum = 0, cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    sum += list.get(j);
                    cnt++;
                }
            }
            
            if (sum == 0) {
                f[i] = cnt - 1;
                for (int j = 1; j < i; j++) {
                    if ((j & i) == j) {
                        f[i] = Math.min(f[i], f[j] + f[i - j]);
                    }
                }
            }
        }
        
        return f[(1 << n) - 1];
    }
}
