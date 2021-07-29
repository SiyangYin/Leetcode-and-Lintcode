import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minTransfers(int[][] transactions) {
        int n = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] tran : transactions) {
            map.putIfAbsent(tran[0], n++);
            map.putIfAbsent(tran[1], n++);
        }
        
        int[] f = new int[1 << n], out = new int[n];
        for (int[] trans : transactions) {
            int from = map.get(trans[0]), to = map.get(trans[1]), x = trans[2];
            out[from] += x;
            out[to] -= x;
        }
    
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 1; i < 1 << n; i++) {
            int sum = 0, cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    sum += out[j];
                    cnt++;
                }
            }
            
            if (sum == 0) {
                f[i] = cnt - 1;
                for (int j = 0; j < 1 << n; j++) {
                    if ((j & i) == j) {
                        f[i] = Math.min(f[i], f[j] + f[i - j]);
                    }
                }
            }
        }
        
        return f[(1 << n) - 1];
    }
    
    public static void main(String[] args) {
        int[][] trans = {{0,1,10},{2,0,5}};
        System.out.println(new Solution().minTransfers(trans));
    }
}
