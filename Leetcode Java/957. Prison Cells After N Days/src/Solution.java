import java.util.Arrays;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] cache = new int[1 << 8];
        Arrays.fill(cache, -1);
        
        int cur = 0;
        for (int i = 7; i >= 0; i--) {
            if (cells[i] == 1) {
                cur |= 1 << (7 - i);
            }
        }
        
        cache[cur] = 0;
        
        int len = 0;
        for (int i = 1; i <= N; i++) {
            cur = ~((cur << 1) ^ (cur >> 1)) & 0X7E;
            if (cache[cur] != -1) {
                len = i - cache[cur];
                break;
            } else {
                cache[cur] = i;
            }
        }
        
        if (len == 0) {
            return get(cur);
        }
        
        int idx = (N - cache[cur]) % len + cache[cur];
        for (int i = 0; i < 1 << 8; i++) {
            if (cache[i] == idx) {
                return get(i);
            }
        }
        
        return null;
    }
    
    private int[] get(int cur) {
        int[] res = new int[8];
        int idx = 7;
        while (cur != 0) {
            res[idx--] = cur & 1;
            cur >>= 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] c = {1, 0, 0, 1, 0, 0, 1, 0};
        // int[] c = {0,1,0,1,1,0,0,1};
        System.out.println(Arrays.toString(new Solution().prisonAfterNDays(c, 1000000000)));
    }
}
