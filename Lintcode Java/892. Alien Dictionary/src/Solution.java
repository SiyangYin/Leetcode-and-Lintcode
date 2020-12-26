import java.util.*;

public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        if (words == null || words.length == 0) {
            return "";
        }
        
        if (words.length == 1) {
            char[] res = words[0].toCharArray();
            Arrays.sort(res);
            return new String(res);
        }
        
        Map<Character, Set<Character>> graph = buildGraph(words);
        if (graph == null) {
            return "";
        }
        
        Map<Character, Integer> indegrees = getIndegrees(graph);
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                pq.offer(entry.getKey());
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char cur = pq.poll();
            sb.append(cur);
            for (char next : graph.get(cur)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    pq.offer(next);
                }
            }
        }
        
        if (sb.length() != graph.size()) {
            return "";
        }
        
        return sb.toString();
    }
    
    private Map<Character, Integer> getIndegrees(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegrees = new HashMap<>();
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            indegrees.putIfAbsent(entry.getKey(), 0);
            for (char ch : entry.getValue()) {
                indegrees.put(ch, indegrees.getOrDefault(ch, 0) + 1);
            }
        }
        
        return indegrees;
    }
    
    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                graph.putIfAbsent(words[i].charAt(j), new HashSet<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int idx = 0;
            while (idx < w1.length() && idx < w2.length()) {
                char c1 = w1.charAt(idx), c2 = w2.charAt(idx);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    break;
                }
                idx++;
            }
            
            if (idx == w2.length() && w2.length() < w1.length()) {
                return null;
            }
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        // String[] words = {"zy", "zx"};
        // System.out.println(new Solution().alienOrder(words));
        
        char[] c = {'a', 'b', 'c'};
        System.out.println(new String(c));
    }
}
