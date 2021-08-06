import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String crackSafe(int n, int k) {
        String start = "0".repeat(n - 1);
        StringBuilder sb = new StringBuilder();
        dfs(start, new HashSet<>(), k, sb);
        return sb + start;
    }
    
    private void dfs(String s, Set<String> set, int k, StringBuilder sb) {
        for (int i = 0; i < k; i++) {
            String next = s + i;
            if (set.add(next)) {
                dfs(next.substring(1), set, k, sb);
                sb.append(i);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().crackSafe(2, 3));
    }
}
