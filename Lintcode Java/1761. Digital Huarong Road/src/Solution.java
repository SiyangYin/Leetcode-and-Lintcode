import java.util.*;

public class Solution {
    /**
     * @param A: the initial state
     * @param k: the limit
     * @return: the steps
     */
    public String digitalHuarongRoad(int[][] A, int k) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        for (int[] row : A) {
            for (int ch : row) {
                sb.append(ch);
            }
        }
        
        String start = sb.toString();
        if ("123456780".equals(start)) {
            return "true";
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        Set<String> vis = new HashSet<>();
        vis.add(start);
        int[] d = {1, 0, -1, 0, 1};
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            if (res > k) {
                return "false";
            }
            
            for (int i = queue.size() - 1; i >= 0; i--) {
                String cur = queue.poll();
                for (String next : getNexts(cur, vis, d)) {
                    if ("123456780".equals(next)) {
                        return "true";
                    }
                    
                    vis.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return "false";
    }
    
    private Set<String> getNexts(String s, Set<String> vis, int[] d) {
        int x = 0, y = 0, old = 0;
        for (int i = 0; i < 9; i++) {
            if (s.charAt(i) == '0') {
                x = i / 3;
                y = i % 3;
                old = i;
                break;
            }
        }
        
        Set<String> set = new HashSet<>();
        char[] chs = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (0 <= nextX && nextX < 3 && 0 <= nextY && nextY < 3) {
                int cur = nextX * 3 + nextY;
                swap(chs, old, cur);
                String next = new String(chs);
                if ("123456780".equals(next)) {
                    set.clear();
                    set.add(next);
                    return set;
                }
                
                if (!vis.contains(next)) {
                    set.add(next);
                }
                
                swap(chs, old, cur);
            }
        }
        
        return set;
    }
    
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[][] a = {{1, 0, 3}, {4, 2, 6}, {7, 5, 8}};
        System.out.println(new Solution().digitalHuarongRoad(a, 3));
    }
}
