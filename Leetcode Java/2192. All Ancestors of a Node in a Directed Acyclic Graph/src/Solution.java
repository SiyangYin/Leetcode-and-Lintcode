import java.util.*;

public class Solution {
    
    int[] h, e, ne;
    int idx;
    
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        h = new int[n];
        Arrays.fill(h, -1);
        int m = edges.length;
        e = new int[m];
        ne = new int[m];
        int[] ind = new int[n];
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            add(a, b);
            ind[b]++;
        }
        
        BitSet[] bitSets = new BitSet[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            bitSets[i] = new BitSet();
            if (ind[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = h[cur]; i != -1; i = ne[i]) {
                int ne = e[i];
                ind[ne]--;
                BitSet set = bitSets[ne];
                set.or(bitSets[cur]);
                set.set(cur);
                if (ind[ne] == 0) {
                    q.offer(ne);
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
            BitSet set = bitSets[i];
            int idx = 0;
            while (set.nextSetBit(idx) != -1) {
                res.get(i).add(set.nextSetBit(idx));
                idx = set.nextSetBit(idx) + 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int n = 8;
        int[][] e = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        List<List<Integer>> lists = new Solution().getAncestors(n, e);
        System.out.println(lists);
    }
}
