import java.util.Arrays;

public class Solution {
    
    class Deque {
        private int head, tail;
        private int[] q;
        
        public Deque(int size) {
            q = new int[size];
        }
        
        public int front() {
            return q[head];
        }
        
        public int back() {
            return q[tail - 1];
        }
        
        public void push(int x) {
            q[tail++] = x;
        }
        
        public void pop() {
            head++;
        }
        
        public boolean empty() {
            return tail == head;
        }
        
        public void clear() {
            head = tail = 0;
        }
    }
    
    public int countPalindromicSubsequences(String s) {
        int MOD = (int) (1e9 + 7);
        int n = s.length();
        int[][] f = new int[n][n];
        for (int[] row : f) {
            Arrays.fill(row, 1);
        }
        
        for (int i = 0; i < n; i++) {
            f[i][i]++;
        }
        
        Deque[] q = new Deque[4];
        for (int i = 0; i < 4; i++) {
            q[i] = new Deque(s.length());
        }
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < 4; i++) {
                q[i].clear();
            }
            
            for (int i = 0; i < n; i++) {
                q[s.charAt(i) - 'a'].push(i);
                int j = i - len + 1;
                if (j >= 0) {
                    for (int k = 0; k < 4; k++) {
                        while (!q[k].empty() && q[k].front() < j) {
                            q[k].pop();
                        }
                        
                        if (!q[k].empty()) {
                            f[j][i]++;
                            int l = q[k].front(), r = q[k].back();
                            if (l < r) {
                                f[j][i] = (f[j][i] + f[l + 1][r - 1]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        
        return (f[0][n - 1] + MOD - 1) % MOD;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countPalindromicSubsequences("bccb"));
    }
}
