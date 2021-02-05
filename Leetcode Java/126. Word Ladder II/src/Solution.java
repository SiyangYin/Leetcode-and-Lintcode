import java.util.*;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) {
            return res;
        }
        
        Map<String, Integer> dist = new HashMap<>();
        dist.put(beginWord, 0);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        OUT:
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            char[] chs = cur.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch != c) {
                        chs[i] = ch;
                        String next = new String(chs);
                        if (!dist.containsKey(next) && set.contains(next)) {
                            dist.put(next, dist.get(cur) + 1);
                            queue.offer(next);
                        }
                        
                        if (next.equals(endWord)) {
                            break OUT;
                        }
                        
                    }
                }
                chs[i] = c;
            }
        }
        
        dfs(endWord, beginWord, dist, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(String cur, String begin, Map<String, Integer> dist, List<String> list, List<List<String>> res) {
        list.add(cur);
        if (cur.equals(begin)) {
            Collections.reverse(list);
            res.add(new ArrayList<>(list));
            Collections.reverse(list);
            list.remove(list.size() - 1);
            return;
        }
        
        char[] chs = cur.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != c) {
                    chs[i] = ch;
                    String next = new String(chs);
                    if (dist.containsKey(next) && dist.get(next) == dist.get(cur) - 1) {
                        dfs(next, begin, dist, list, res);
                    }
                }
            }
            chs[i] = c;
        }
        
        list.remove(list.size() - 1);
    }
    
    public static void main(String[] args) {
        String begin = "hit", end = "cog";
        List<String> ll = new ArrayList<>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};
        
        System.out.println(new Solution().findLadders(begin, end, ll));
    }
}
