import java.util.*;

public class Solution {
    
    class UnionFind {
        private int[] p;
        
        public UnionFind(int size) {
            p = new int[size];
            for (int i = 0; i < size; i++) {
                p[i] = i;
            }
        }
        
        public int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                p[px] = py;
            }
        }
    }
    
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Integer> id = new HashMap<>();
        List<String> list = new ArrayList<>();
        int idx = 0;
        for (List<String> synonym : synonyms) {
            String s1 = synonym.get(0), s2 = synonym.get(1);
            if (!id.containsKey(s1)) {
                list.add(s1);
                id.put(s1, idx++);
            }
            if (!id.containsKey(s2)) {
                list.add(s2);
                id.put(s2, idx++);
            }
        }
        
        UnionFind uf = new UnionFind(id.size());
        for (List<String> synonym : synonyms) {
            String s1 = synonym.get(0), s2 = synonym.get(1);
            uf.union(id.get(s1), id.get(s2));
        }
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int p = uf.find(i);
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }
        for (List<Integer> value : map.values()) {
            value.sort((s1, s2) -> list.get(s1).compareTo(list.get(s2)));
        }
        
        List<String> res = new ArrayList<>();
        dfs(0, text.split(" "), map, id, list, uf, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(int pos, String[] spl, Map<Integer, List<Integer>> map, Map<String, Integer> id, List<String> list, UnionFind uf, StringBuilder sb, List<String> res) {
        if (pos == spl.length) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        
        String s = spl[pos];
        if (!id.containsKey(s)) {
            sb.append(s).append(' ');
            dfs(pos + 1, spl, map, id, list, uf, sb, res);
            sb.setLength(sb.length() - s.length() - 1);
        } else {
            for (int idx : map.get(uf.find(id.get(s)))) {
                String t = list.get(idx);
                sb.append(t).append(' ');
                dfs(pos + 1, spl, map, id, list, uf, sb, res);
                sb.setLength(sb.length() - t.length() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        List<List<String>> syn = new ArrayList<>(){{
            add(Arrays.asList("happy", "joy"));
            add(Arrays.asList("sad", "sorrow"));
            add(Arrays.asList("joy", "cheerful"));
        }};
        String text = "I am happy today but was sad yesterday";
        System.out.println(new Solution().generateSentences(syn, text));
    }
}
