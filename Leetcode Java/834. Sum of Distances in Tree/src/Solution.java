import java.util.Arrays;

public class Solution {
    
    class Tree {
        int[] h, e, ne;
        int idx;
        
        public Tree(int size) {
            h = new int[size];
            Arrays.fill(h, -1);
            e = new int[size - 1 << 1];
            ne = new int[size - 1 << 1];
        }
        
        public void add(int a, int b) {
            e[idx] = b;
            ne[idx] = h[a];
            h[a] = idx++;
        }
    }
    
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Tree tree = new Tree(n);
        for (int[] edge : edges) {
            tree.add(edge[0], edge[1]);
            tree.add(edge[1], edge[0]);
        }
        
        int[] res = new int[n], cnt = new int[n];
        res[0] = dfs1(0, 0, tree, cnt);
        dfs2(0, 0, tree, n, res, cnt);
        
        return res;
    }
    
    private void dfs2(int u, int from, Tree tree, int n, int[] res, int[] cnt) {
        if (u != 0) {
            res[u] = res[from] + n - cnt[u] * 2;
        }
        
        for (int i = tree.h[u]; i != -1; i = tree.ne[i]) {
            int next = tree.e[i];
            if (next != from) {
                dfs2(next, u, tree, n, res, cnt);
            }
        }
    }
    
    private int dfs1(int u, int from, Tree tree, int[] cnt) {
        int res = 0;
        cnt[u] = 1;
        for (int i = tree.h[u]; i != -1; i = tree.ne[i]) {
            int next = tree.e[i];
            if (next == from) {
                continue;
            }
            
            res += dfs1(next, u, tree, cnt);
            res += cnt[next];
            cnt[u] += cnt[next];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] e = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(new Solution().sumOfDistancesInTree(n, e)));
    }
}
