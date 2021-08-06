import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    
    class BinaryIndexTree {
        
        private int size;
        private int[] tr;
        
        public BinaryIndexTree(int size) {
            this.size = size;
            tr = new int[size + 1];
        }
        
        public void add(int idx, int v) {
            for (int i = idx; i <= size; i += lowbit(i)) {
                tr[i] += v;
            }
        }
        
        public int sum(int idx) {
            int res = 0;
            for (int i = idx; i > 0; i -= lowbit(i)) {
                res += tr[i];
            }
            return res;
        }
        
        private int lowbit(int x) {
            return x & -x;
        }
    }
    
    public String minInteger(String s, int k) {
        int n = s.length();
        s = " " + s;
        Queue<Integer>[] q = (Queue<Integer>[]) new ArrayDeque[10];
        for (int i = 1; i <= n; i++) {
            int x = s.charAt(i) - '0';
            if (q[x] == null) {
                q[x] = new ArrayDeque<>();
            }
            
            q[x].add(i);
        }
        
        BinaryIndexTree tr = new BinaryIndexTree(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (q[j] != null && !q[j].isEmpty()) {
                    int t = q[j].peek(), pos = t + tr.sum(t);
                    if (pos - i <= k) {
                        k -= pos - i;
                        sb.append(j);
                        q[j].poll();
                        tr.add(1, 1);
                        tr.add(t, -1);
                        break;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minInteger("4321", 4));
    }
}
