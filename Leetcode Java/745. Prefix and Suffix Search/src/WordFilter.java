import java.util.*;

class WordFilter {
    private TrieNode root1 = new TrieNode();
    private TrieNode root2 = new TrieNode();
    private Map<String, Integer> map = new HashMap<>();
    private int index;
    public WordFilter(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            map.put(s, i);
            TrieNode node1 = root1;
            TrieNode node2 = root2;
            for (int j = 0; j < s.length(); j++) {
                if (node1.child[s.charAt(j) - 'a'] == null) {
                    node1.child[s.charAt(j) - 'a'] = new TrieNode();
                }
                node1 = node1.child[s.charAt(j) - 'a'];
                if (node2.child[s.charAt(s.length() - 1 - j) - 'a'] == null) {
                    node2.child[s.charAt(s.length() - 1 - j) - 'a'] = new TrieNode();
                }
                node2 = node2.child[s.charAt(s.length() - 1 - j) - 'a'];
            }
            node1.isWordEnd = true;
            node2.isWordEnd = true;
        }
    }

    public int f(String pref, String suff) {
        TrieNode node1 = root1;
        TrieNode node2 = root2;
        for (int i = 0; i < pref.length(); i++) {
            if (node1.child[pref.charAt(i) - 'a'] != null) {
                node1 = node1.child[pref.charAt(i) - 'a'];
            }
            else {
                return -1;
            }
        }
        for (int i = suff.length() - 1; i >= 0; i--) {
            if (node2.child[suff.charAt(i) - 'a'] != null) {
                node2 = node2.child[suff.charAt(i) - 'a'];
            }
            else {
                return -1;
            }
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(pref);
        sb2.append(suff).reverse();
        index = -1;
        if (pref.length() > suff.length()) {
            dfs(node1, sb1, false, pref, suff);
        }
        else {
            dfs(node2, sb2, true, pref, suff);
        }
        return index;
    }

    public void dfs(TrieNode node, StringBuilder sb, boolean reverse, String pref, String suff) {
        if (node.isWordEnd) {
            if (!reverse) {
                String s = sb.toString();
                if (s.endsWith(suff) && map.get(s) > index) {
                    index = map.get(s);
                }
            }
            else {
                String s = new StringBuilder(sb).reverse().toString();
                if (s.startsWith(pref) && map.get(s) > index) {
                    index = map.get(s);
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                sb.append((char)('a' + i));
                dfs(node.child[i], sb, reverse, pref, suff);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new WordFilter(new String[]{"apple"}).f("a","e"));
    }
}

class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean isWordEnd = false;
}
