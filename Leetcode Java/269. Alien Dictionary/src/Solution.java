import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 1) {
            return words[0];
        }
        
        int[] indegrees = new int[26];
        Arrays.fill(indegrees, Integer.MIN_VALUE);
        
        Map<Character, Set<Character>> graph = buildGraph(words, indegrees);
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        int num = 0;
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer((char) ('a' + i));
            }
            if (indegrees[i] != Integer.MIN_VALUE) {
                num++;
            }
        }
        
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);
            
            if (graph.containsKey(cur)) {
                for (char ch : graph.get(cur)) {
                    indegrees[ch - 'a']--;
                    if (indegrees[ch - 'a'] == 0) {
                        queue.offer(ch);
                    }
                }
            }
        }
        
        return sb.length() == num ? sb.toString() : "";
    }
    
    private Map<Character, Set<Character>> buildGraph(String[] words, int[] indegrees) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int len1 = s1.length(), len2 = s2.length();
            boolean first = true;
            for (int j = 0; j < Math.max(len1, len2); j++) {
                if (j < len1) {
                    indegrees[s1.charAt(j) - 'a'] = 0;
                }
                if (j < len2) {
                    indegrees[s2.charAt(j) - 'a'] = 0;
                }
                if (j < Math.min(len1, len2) && s1.charAt(j) != s2.charAt(j) && first) {
                    first = false;
                    graph.putIfAbsent(s1.charAt(j), new HashSet<>());
                    graph.get(s1.charAt(j)).add(s2.charAt(j));
                }
                
                if (j == Math.min(len1, len2) && first && len1 > len2) {
                    Arrays.fill(indegrees, Integer.MIN_VALUE);
                    return null;
                }
            }
        }
        
        for (Map.Entry<Character, Set<Character>> entry : graph.entrySet()) {
            for (char ch : entry.getValue()) {
                indegrees[ch - 'a']++;
            }
        }
        
        return graph;
    }
    
    public static void main(String[] args) {
        // String[] words = {"za", "zb", "ca", "cb"};
        String[] words = {"z", "z"};
        System.out.println(new Solution().alienOrder(words));
    }
}
