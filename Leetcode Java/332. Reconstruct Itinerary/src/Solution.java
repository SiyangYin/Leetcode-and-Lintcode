import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs("JFK", graph, res);
        Collections.reverse(res);
        return res;
    }
    
    private void dfs(String cur, Map<String, PriorityQueue<String>> graph, List<String> res) {
        if (graph.containsKey(cur)) {
            PriorityQueue<String> nexts = graph.get(cur);
            while (!nexts.isEmpty()) {
                dfs(nexts.poll(), graph, res);
            }
        }
        
        res.add(cur);
    }
    
    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        List<List<String>> tic = new ArrayList<>();
        tic.add(Arrays.asList("JFK", "SFO"));
        tic.add(Arrays.asList("JFK", "ATL"));
        tic.add(Arrays.asList("SFO", "ATL"));
        tic.add(Arrays.asList("ATL", "JFK"));
        tic.add(Arrays.asList("ATL", "SFO"));
        
        // tic.add(Arrays.asList("JFK", "KUL"));
        // tic.add(Arrays.asList("JFK", "NRT"));
        // tic.add(Arrays.asList("NRT", "JFK"));
        System.out.println(new Solution().findItinerary(tic));
    }
}
