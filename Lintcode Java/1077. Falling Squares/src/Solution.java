import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class SegTree {
        class Node {
            int l, r, M, lazy;
            
            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }
        
        private Node[] tr;
        
        public SegTree(int size) {
            tr = new Node[size << 2];
            build(1, 0, size - 1);
        }
        
        public void build(int u, int l, int r) {
            tr[u] = new Node(l, r);
            if (l == r) {
                return;
            }
            
            int m = l + (r - l >> 1);
            build(u << 1, l, m);
            build(u << 1 | 1, m + 1, r);
        }
        
        public int query(int u, int l, int r) {
            if (l <= tr[u].l && tr[u].r <= r) {
                return tr[u].M;
            }
            
            pushdown(u);
            int res = 0, m = tr[u].l + (tr[u].r - tr[u].l >> 1);
            if (l <= m) {
                res = Math.max(res, query(u << 1, l, r));
            }
            if (m + 1 <= r) {
                res = Math.max(res, query(u << 1 | 1, l, r));
            }
            
            return res;
        }
        
        public void update(int u, int l, int r, int v) {
            if (l <= tr[u].l && tr[u].r <= r) {
                tr[u].M = tr[u].lazy = v;
                return;
            }
            
            pushdown(u);
            int m = tr[u].l + (tr[u].r - tr[u].l >> 1);
            if (l <= m) {
                update(u << 1, l, r, v);
            }
            if (m + 1 <= r) {
                update(u << 1 | 1, l, r, v);
            }
            pushup(u);
        }
        
        private void pushup(int u) {
            tr[u].M = Math.max(tr[u << 1].M, tr[u << 1 | 1].M);
        }
        
        private void pushdown(int u) {
            if (tr[u].lazy != 0) {
                tr[u << 1].lazy = tr[u << 1 | 1].lazy = tr[u].lazy;
                tr[u << 1].M = tr[u << 1 | 1].M = tr[u].lazy;
                tr[u].lazy = 0;
            }
        }
    }
    
    /**
     * @param positions: a list of (left, side_length)
     * @return: return a list of integer
     */
    public List<Integer> fallingSquares(int[][] positions) {
        // write your code here
        List<Integer> xs = new ArrayList<>();
        for (int[] p : positions) {
            int a = p[0], b = p[0] + p[1];
            xs.add(a * 2);
            xs.add(b * 2);
            xs.add(a + b);
        }
        
        xs = unique(xs);
        SegTree segTree = new SegTree(xs.size());
        
        List<Integer> res = new ArrayList<>();
        for (int[] p : positions) {
            int a = p[0], b = p[0] + p[1];
            a = get(a * 2, xs);
            b = get(b * 2, xs);
            int h = segTree.query(1, a + 1, b - 1);
            segTree.update(1, a, b, h + p[1]);
            res.add(segTree.query(1, 0, xs.size() - 1));
        }
        
        return res;
    }
    
    private int get(int x, List<Integer> xs) {
        int l = 0, r = xs.size() - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (xs.get(m) >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private List<Integer> unique(List<Integer> xs) {
        xs.sort(Integer::compareTo);
        int j = 0;
        for (int i = 0; i < xs.size(); i++) {
            if (j == 0 || xs.get(j - 1) != xs.get(i)) {
                xs.set(j++, xs.get(i));
            }
        }
        
        return xs.subList(0, j);
    }
    
    public static void main(String[] args) {
        int[][] p = {{1, 2}, {2, 3}, {6, 1}};
        System.out.println(new Solution().fallingSquares(p));
    }
}
