import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param N:     an integer
     * @param edges: the edges
     * @return: a list ans, where ans[i] is the sum of the distances between node i and all other nodes
     */
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        // Write your code here
        List<Integer>[] tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            tree[x].add(y);
            tree[y].add(x);
        }
        
        int[] res = new int[N], cnt = new int[N];
        dfs1(0, 0, 0, cnt, res, tree);
        dfs2(0, 0, cnt, res, N, tree);
        return res;
    }
    
    private void dfs2(int cur, int from, int[] cnt, int[] res, int N, List<Integer>[] tree) {
        if (cur != from) {
            res[cur] = res[from] + (N - cnt[cur] * 2);
        }
        for (int next : tree[cur]) {
            if (next != from) {
                dfs2(next, cur, cnt, res, N, tree);
            }
        }
    }
    
    private void dfs1(int cur, int from, int step, int[] cnt, int[] res, List<Integer>[] tree) {
        res[0] += step;
        cnt[cur] = 1;
        for (int next : tree[cur]) {
            if (next != from) {
                dfs1(next, cur, step + 1, cnt, res, tree);
                cnt[cur] += cnt[next];
            }
        }
    }
    
    public static void main(String[] args) {
        int n = 6;
        int[][] e = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        System.out.println(Arrays.toString(new Solution().sumOfDistancesInTree(n, e)));
    }
}
