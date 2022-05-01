import java.util.*;

public class Solution {
    
    int[] h, e, ne;
    int idx;
    
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
    
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] qs) {
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
        
        Queue<Integer> q = new LinkedList<>();
        List<BitSet> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                q.offer(i);
            }
            list.add(new BitSet());
        }
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            BitSet curSet = list.get(cur);
            for (int i = h[cur]; i != -1 ; i = ne[i]) {
                int v = e[i];
                BitSet set = list.get(v);
                set.set(cur);
                set.or(curSet);
                ind[v]--;
                if (ind[v] == 0) {
                    q.offer(v);
                }
            }
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] query : qs) {
            int a = query[0], b = query[1];
            res.add(list.get(b).get(a));
        }
        
        return res;
    }
}
