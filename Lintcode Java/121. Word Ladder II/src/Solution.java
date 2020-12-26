import java.util.*;

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (start.equals(end)) {
            List<String> list = new ArrayList<>();
            list.add(start);
            res.add(list);
            return res;
        }
        
        dict.add(start);
        dict.add(end);
        
        Map<String, Set<String>> graph = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(end);
        Set<String> visited = new HashSet<>();
        visited.add(end);
        
        boolean found = false;
        while (!queue.isEmpty()) {
            visited.addAll(queue);
            
            Set<String> nextLayer = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (String next : getNexts(cur, dict, visited)) {
                    graph.putIfAbsent(next, new TreeSet<>());
                    graph.get(next).add(cur);
                    if (next.equals(start)) {
                        found = true;
                    }
                    
                    nextLayer.add(next);
                }
            }
            
            if (found) {
                break;
            }
            
            queue.addAll(nextLayer);
        }
        
        visited.clear();
        dfs(start, end, graph, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(String cur, String end, Map<String, Set<String>> graph, List<String> list, List<List<String>> res) {
        list.add(cur);
        if (cur.equals(end)) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        
        if (graph.containsKey(cur)) {
            for (String next : graph.get(cur)) {
                dfs(next, end, graph, list, res);
            }
        }
        
        list.remove(list.size() - 1);
    }
    
    private Set<String> getNexts(String cur, Set<String> dict, Set<String> visited) {
        Set<String> nexts = new HashSet<>();
        char[] chs = cur.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char ch = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chs[i] = c;
                String next = String.valueOf(chs);
                if (dict.contains(next) && !visited.contains(next)) {
                    nexts.add(next);
                }
            }
            chs[i] = ch;
        }
        
        return nexts;
    }
    
    public static void main(String[] args) {
        String start = "hit", end = "cog";
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        
        System.out.println(new Solution().findLadders(start, end, dict));
    }
}
