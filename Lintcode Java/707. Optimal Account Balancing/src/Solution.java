import java.util.*;

public class Solution {
    /**
     * @param edges: a directed graph where each edge is represented by a tuple
     * @return: the number of edges
     */
    public int balanceGraph(int[][] edges) {
        // Write your code here
        Map<Integer, Integer> debt = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], val = edge[2];
            debt.put(from, debt.getOrDefault(from, 0) - val);
            debt.put(to, debt.getOrDefault(to, 0) + val);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : debt.entrySet()) {
            if (entry.getValue() != 0) {
                list.add(entry.getValue());
            }
        }
        
        if (list.isEmpty()) {
            return 0;
        }
        
        int n = list.size();
        int[] f = new int[1 << n];
        Arrays.fill(f, 0x3f3f3f3f);
        
        for (int i = 1; i < 1 << n; i++) {
            int sum = 0, cnt = 0;
            for (int j = 0; j < n; j++) {
                if ((1 << j & i) != 0) {
                    sum += list.get(j);
                    cnt++;
                }
            }
            
            if (sum == 0) {
                f[i] = cnt - 1;
                for (int j = 1; j < i; j++) {
                    if ((i & j) == j) {
                        f[i] = Math.min(f[i], f[j] + f[i - j]);
                    }
                }
            }
        }
        
        return f[(1 << n) - 1];
    }
    
    public static void main(String[] args) {
        int[][] e = {{0, 1, 10}, {2, 0, 5}};
        System.out.println(new Solution().balanceGraph(e));
    }
}
