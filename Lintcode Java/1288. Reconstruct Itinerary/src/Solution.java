import java.util.*;

public class Solution {
    /**
     * @param tickets:
     * @return: nothing
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        // Write your code here
        List<String> res = new ArrayList<>();
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        Deque<String> stack = new LinkedList<>();
        String cur = "JFK";
        stack.push(cur);
        while (!stack.isEmpty()) {
            if (graph.containsKey(cur) && !graph.get(cur).isEmpty()) {
                stack.push(cur);
                cur = graph.get(cur).poll();
            } else {
                res.add(cur);
                cur = stack.pop();
            }
        }
        
        Collections.reverse(res);
        return res;
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
}
