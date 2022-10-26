import java.util.HashMap;
import java.util.Map;

public class WordDictionary3 {
    private TrieNode root;
    public WordDictionary3() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        dfs1(0, word, root);
    }

    public boolean search(String word) {
        return dfs2(0, word, root);
    }

    public boolean dfs2(int i, String word, TrieNode node) {
        if (i == word.length()) {
            return node.isWordEnd;
        }
        if (word.charAt(i) != '.') {
            if (node.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            else {
                return dfs2(i + 1, word, node.children[word.charAt(i) - 'a']);
            }
        }
        else {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && dfs2(i + 1, word, node.children[j])) {
                    return true;
                }
            }
            return false;
        }
    }

    public void dfs1(int i, String word, TrieNode node) {
        if (i == word.length()) {
            node.isWordEnd = true;
            return;
        }
        if (node.children[word.charAt(i) - 'a'] == null) {
            node.children[word.charAt(i) - 'a'] = new TrieNode();
        }
        dfs1(i + 1, word, node.children[word.charAt(i) - 'a']);
    }
    
    public static void main(String[] args) {
        WordDictionary3 dic = new WordDictionary3();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        System.out.println(dic.search("pad"));
        System.out.println(dic.search("bad"));
        System.out.println(dic.search(".ad"));
        System.out.println(dic.search("b.."));
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
}