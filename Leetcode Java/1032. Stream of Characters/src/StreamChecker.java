import java.util.LinkedList;
import java.util.Queue;

public class StreamChecker {
    
    class Node {
        Node[] child;
        Node ne;
        boolean word;
        
        public Node() {
            child = new Node[26];
        }
    }
    
    Node root, cur;
    
    void insert(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            
            cur = cur.child[idx];
        }
        
        cur.word = true;
    }
    
    void build() {
        root.ne = root;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (root.child[i] != null) {
                q.offer(root.child[i]);
                root.child[i].ne = root;
            } else {
                root.child[i] = root;
            }
        }
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 26; i++) {
                if (cur.child[i] != null) {
                    cur.child[i].ne = cur.ne.child[i];
                    cur.child[i].word |= cur.ne.child[i].word;
                    q.offer(cur.child[i]);
                } else {
                    if (cur.ne == null) {
                        cur.ne = root;
                    }
                    cur.child[i] = cur.ne.child[i];
                }
            }
        }
    }
    
    public StreamChecker(String[] words) {
        root = new Node();
        cur = root;
        for (String w : words) {
            insert(w);
        }
        
        build();
    }
    
    public boolean query(char ch) {
        cur = cur.child[ch - 'a'];
        return cur.word;
    }
    
    public static void main(String[] args) {
        String[] ws = {"cd", "f", "kl"};
        StreamChecker checker = new StreamChecker(ws);
        System.out.println(checker.query('a'));
        System.out.println(checker.query('x'));
        System.out.println(checker.query('y'));
        System.out.println(checker.query('z'));
    }
}
