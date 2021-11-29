import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    
    class Node {
        int l, r, h;
        
        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    
    Node[] tr;
    
    void pushdown(int u) {
        if (tr[u].h > 0) {
            tr[u << 1].h = tr[u << 1 | 1].h = tr[u].h;
            tr[u].h = 0;
        }
    }
    
    void build(int u, int l, int r) {
        tr[u] = new Node(l, r);
        if (l == r) {
            return;
        }
        
        int mid = l + (r - l >> 1);
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }
    
    void modify(int u, int l, int r, int h) {
        if (l <= tr[u].l && tr[u].r <= r) {
            tr[u].h = h;
            return;
        }
        
        pushdown(u);
        int mid = tr[u].l + (tr[u].r - tr[u].l >> 1);
        if (l <= mid) {
            modify(u << 1, l, r, h);
        }
        if (r > mid) {
            modify(u << 1 | 1, l, r, h);
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        Arrays.sort(buildings, (b1, b2) -> Integer.compare(b1[2], b2[2]));
        int[] idx = new int[buildings.length << 1];
        int r = 0;
        for (int[] b : buildings) {
            idx[r++] = b[0];
            idx[r++] = b[1];
        }
        
        Arrays.sort(idx);
        r = 0;
        for (int i = 0; i < idx.length; i++) {
            if (r == 0 || idx[i] != idx[r - 1]) {
                idx[r++] = idx[i];
            }
        }
        
        tr = new Node[r + 1 << 2];
        build(1, 0, r);
        for (int[] b : buildings) {
            modify(1, Arrays.binarySearch(idx, 0, r, b[0]), Arrays.binarySearch(idx, 0, r, b[1]) - 1, b[2]);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, res, idx);
        return res;
    }
    
    int last;
    
    void dfs(int u, List<List<Integer>> res, int[] idx) {
        if (tr[u].l == tr[u].r || tr[u].h > 0) {
            if (tr[u].h != last) {
                res.add(Arrays.asList(idx[tr[u].l], tr[u].h));
            }
            
            last = tr[u].h;
            return;
        }
        
        dfs(u << 1, res, idx);
        dfs(u << 1 | 1, res, idx);
    }
    
    public static void main(String[] args) {
        int[][] b = {
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        
        System.out.println(new Solution2().getSkyline(b));
    }
}
