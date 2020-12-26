public class MagicDictionary {
    
    class Node {
        boolean isWord;
        Node[] next;
        Node() {
            next = new Node[26];
        }
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            insert(word);
        }
    }
    
    private void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        
        cur.isWord = true;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return dfs(root, word, 0, 0);
    }
    
    private boolean dfs(Node cur, String word, int start, int changed) {
        if (changed >= 2) {
            return false;
        }
        
        if (start == word.length()) {
            return changed == 1 && cur.isWord;
        }
        
        char c = word.charAt(start);
        if (cur.next[c - 'a'] != null) {
            if (dfs(cur.next[c - 'a'], word, start + 1, changed)) {
                return true;
            }
            for (int i = 0; i < cur.next.length; i++) {
                if (i != c - 'a' && cur.next[i] != null && dfs(cur.next[i], word, start + 1, changed + 1)) {
                    return true;
                }
            }
        } else {
            if (changed >= 1) {
                return false;
            }
    
            for (int i = 0; i < cur.next.length; i++) {
                if (cur.next[i] != null && dfs(cur.next[i], word, start + 1, changed + 1)) {
                    return true;
                }
            }
            
        }
        return false;
    }
    
    public static void main(String[] args) {
        MagicDictionary dic = new MagicDictionary();
        
        // dic.buildDict(new String[]{"hello", "hallo", "leetcode"});
        dic.buildDict(new String[]{"a","b","ab","abc","abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj","abcdefghijawefe","aefawoifjowajfowafjeoawjfaow","cba","cas","aaewfawi","babcda","bcd","awefj"});
        
        System.out.println(dic.search("a"));
        System.out.println(dic.search("b"));
        System.out.println(dic.search("c"));
        System.out.println(dic.search("d"));
        System.out.println(dic.search("e"));
        System.out.println(dic.search("f"));
        System.out.println(dic.search("ab"));
        
        System.out.println(dic.search("ba"));
        
        System.out.println(dic.search("abc"));
        System.out.println(dic.search("cba"));
        System.out.println(dic.search("abb"));
        System.out.println(dic.search("bb"));
        System.out.println(dic.search("aa"));
        System.out.println(dic.search("bbc"));
        System.out.println(dic.search("abcd"));
    }
}
