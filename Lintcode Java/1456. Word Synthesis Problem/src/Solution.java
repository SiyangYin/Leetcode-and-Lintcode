import java.util.*;

public class Solution {
    /**
     * @param target: the target string
     * @param words:  words array
     * @return: whether the target can be matched or not
     */
    public boolean matchFunction(String target, String[] words) {
        // Write your code here
        int n = words.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] match = new int[n];
        Arrays.fill(match, -1);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < target.length(); i++) {
            for (int j = 0; j < n; j++) {
                if (words[j].indexOf(target.charAt(i)) != -1) {
                    map.putIfAbsent(i, new ArrayList<>());
                    map.get(i).add(j);
                }
            }
        }
        
        int cnt = 0;
        for (int i = 0; i < target.length(); i++) {
            Arrays.fill(visited, false);
            if (dfs(i, match, visited, map)) {
                cnt++;
            }
        }
        
        return cnt == target.length();
    }
    
    private boolean dfs(int idx, int[] match, boolean[] visited, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(idx)) {
            return false;
        }
    
        for (int next : map.get(idx)) {
            if (!visited[next]) {
                visited[next] = true;
                if (match[next] == -1 || dfs(match[next], match, visited, map)) {
                    match[next] = idx;
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().matchFunction("ally", new String[]{"buy", "discard", "lip", "yep"}));
    }
}
