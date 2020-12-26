import java.util.*;

public class Solution {
    /**
     * @param colors: the colors of grids
     * @return: return the minimum step from position 0 to position n - 1
     */
    public int minimumStep(List<Integer> colors) {
        // write your code here
        if (colors.isEmpty() || colors.size() == 1) {
            return 0;
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.size(); i++) {
            int color = colors.get(i);
            map.putIfAbsent(color, new ArrayList<>());
            map.get(color).add(i);
        }
        
        int res = 0;
        boolean[] visited = new boolean[colors.size()];
        visited[0] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            res++;
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next : getNexts(cur, colors, map, visited)) {
                    if (next == colors.size() - 1) {
                        return res;
                    }
                    
                    visited[next] = true;
                    queue.offer(next);
                }
                
                map.remove(colors.get(cur));
            }
        }
        
        return -1;
    }
    
    private List<Integer> getNexts(int cur, List<Integer> colors, Map<Integer, List<Integer>> map, boolean[] visited) {
        List<Integer> nexts = new ArrayList<>();
        int n = colors.size();
        if (cur + 1 <= n - 1 && !visited[cur + 1]) {
            nexts.add(cur + 1);
        }
        
        if (nexts.contains(n - 1)) {
            return nexts;
        }
        
        if (cur - 1 >= 0 && !visited[cur - 1]) {
            nexts.add(cur - 1);
        }
        
        if (map.containsKey(colors.get(cur))) {
            for (int next : map.get(colors.get(cur))) {
                if (next == n - 1) {
                    return Arrays.asList(n - 1);
                }
        
                if (!visited[next]) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumStep(Arrays.asList(1, 2, 3, 3, 2, 5)));
    }
}
