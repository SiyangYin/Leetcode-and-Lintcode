import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StreamChecker1 {
    private TrieNode root;
    private TrieNode p;
    private List<Character> list;
    public StreamChecker1(String[] words) {
        root = new TrieNode();
        p = root;
        list = new ArrayList<>();
        for (String word : words) {
            insert(root, word);
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        p = root;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (p.children[list.get(i) - 'a'] != null) {
                p = p.children[list.get(i) - 'a'];
                if (p.isWordEnd) return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public void insert(TrieNode root, String word) {
        TrieNode p = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (p.children[word.charAt(i) - 'a'] == null) {
                p.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            p = p.children[word.charAt(i) - 'a'];
        }
        p.isWordEnd = true;
    }
    
    public static void main(String[] args) {
        String[] ws = {"cd", "f", "kl"};
        StreamChecker1 checker = new StreamChecker1(ws);
        System.out.println(checker.query('a'));
        System.out.println(checker.query('x'));
        System.out.println(checker.query('y'));
        System.out.println(checker.query('z'));
    }
}

class TrieNode {
    TrieNode[] children  = new TrieNode[26];
    boolean isWordEnd;
}