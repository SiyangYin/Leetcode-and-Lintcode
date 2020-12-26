import java.util.*;

public class AutocompleteSystem {
    
    class Trie {
        class Node {
            Node[] nexts;
            PriorityQueue<String> minHeap;
            
            public Node() {
                nexts = new Node[128];
                minHeap = new PriorityQueue<>(comp);
            }
        }
        
        Node root;
        
        public Trie(String[] sentences) {
            root = new Node();
            for (int i = 0; i < sentences.length; i++) {
                insert(sentences[i]);
            }
        }
        
        private void insert(String s) {
            Node cur = root;
            addToHeap(s, cur.minHeap);
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.nexts[ch] == null) {
                    cur.nexts[ch] = new Node();
                }
                
                cur = cur.nexts[ch];
                addToHeap(s, cur.minHeap);
            }
        }
    }
    
    private Trie trie;
    private Map<String, Integer> map;
    private Comparator<String> comp;
    private StringBuilder sb;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
        
        comp = (s1, s2) -> {
            int t1 = map.get(s1), t2 = map.get(s2);
            if (t1 != t2) {
                return Integer.compare(t1, t2);
            } else {
                return -s1.compareTo(s2);
            }
        };
        
        trie = new Trie(sentences);
        sb = new StringBuilder();
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        
        if (c == '#') {
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            trie.insert(s);
            sb = new StringBuilder();
            return res;
        }
        
        Trie.Node cur = trie.root;
        sb.append(c);
        
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (cur.nexts[ch] == null) {
                return res;
            }
            
            cur = cur.nexts[ch];
        }
        
        res.addAll(cur.minHeap);
        res.sort(comp.reversed());
        return res;
    }
    
    private void addToHeap(String s, PriorityQueue<String> minHeap) {
        minHeap.remove(s);
        if (minHeap.size() < 3) {
            minHeap.offer(s);
            return;
        }
        
        String top = minHeap.peek();
        if (map.get(s) > map.get(top) || (map.get(s) == map.get(top) && s.compareTo(top) < 0)) {
            minHeap.poll();
            minHeap.offer(s);
        }
    }
    
    public static void main(String[] args) {
        String[] ss = {"i love you", "island", "ironman", "i love leetcode"};
        int[] n = {5, 3, 2, 2};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(ss, n);
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
        System.out.println(autocompleteSystem.input('i'));
        System.out.println(autocompleteSystem.input(' '));
        System.out.println(autocompleteSystem.input('a'));
        System.out.println(autocompleteSystem.input('#'));
    }
}