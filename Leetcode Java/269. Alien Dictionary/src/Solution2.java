import java.util.*;

public class Solution2 {
    public String alienOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }
        
        Set<Character> set = new HashSet<>();
        Map<Character, Set<Character>> graph = buildGraph(words, set);
        if (set.isEmpty()) {
            return "";
        }
        
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        
        StringBuilder sb = new StringBuilder();
        for (char start : set) {
            if (visited[start - 'a'] == -1 && dfs(start, graph, visited, sb)) {
                return "";
            }
        }
        
        return sb.reverse().toString();
    }
    
    private boolean dfs(char s, Map<Character, Set<Character>> graph, int[] visited, StringBuilder sb) {
        visited[s - 'a'] = 0;
        if (graph.containsKey(s)) {
            for (char next : graph.get(s)) {
                if (visited[next - 'a'] == 0) {
                    return true;
                }
                if (visited[next - 'a'] == -1 && dfs(next, graph, visited, sb)) {
                    return true;
                }
            }
        }
        
        visited[s - 'a'] = 1;
        sb.append(s);
        return false;
    }
    
    private Map<Character, Set<Character>> buildGraph(String[] words, Set<Character> set) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int l1 = s1.length(), l2 = s2.length();
            
            boolean firstDiff = true;
            for (int j = 0; j < Math.max(l1, l2); j++) {
                if (j < l1) {
                    set.add(s1.charAt(j));
                }
                if (j < l2) {
                    set.add(s2.charAt(j));
                }
                
                if (j < Math.min(l1, l2) && s1.charAt(j) != s2.charAt(j) && firstDiff) {
                    graph.putIfAbsent(s1.charAt(j), new HashSet<>());
                    graph.get(s1.charAt(j)).add(s2.charAt(j));
                    firstDiff = false;
                }
                
                if (j == Math.min(l1, l2) && firstDiff && l1 > l2) {
                    set.clear();
                    return null;
                }
            }
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // String[] words = {"za", "zb", "ca", "cb"};
        // String[] words = {"z", "x", "z"};
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(new Solution2().alienOrder(words));
    }
}
