import java.util.*;

public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            res = Math.min(res, cur.length());
            for (String next : getNexts(cur, dict)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return res;
    }
    
    private List<String> getNexts(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        
        for (String remove : dict) {
            int start = 0;
            while (true) {
                int ind = s.indexOf(remove, start);
                if (ind != -1) {
                    res.add(s.substring(0, ind) + s.substring(ind + remove.length()));
                    start = ind + 1;
                } else {
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(Arrays.asList("ab", "cd"));
        System.out.println(new Solution().minLength("ccdaabcdbb", set));
    }
}
