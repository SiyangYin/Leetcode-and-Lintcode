import java.util.*;

public class Solution2 {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        dfs("JFK", graph, res);
        Collections.reverse(res);
        return res;
    }
    
    private void dfs(String cur, Map<String, PriorityQueue<String>> graph, List<String> res) {
        if (graph.containsKey(cur)) {
            PriorityQueue<String> minHeap = graph.get(cur);
            while (!minHeap.isEmpty()) {
                dfs(minHeap.poll(), graph, res);
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
        // List<List<String>> t = new ArrayList<>();
        // String[][] ss = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        // for (String[] s : ss) {
        //     t.add(Arrays.asList(s));
        // }
        // System.out.println(new Solution2().findItinerary(t));
    }
}
