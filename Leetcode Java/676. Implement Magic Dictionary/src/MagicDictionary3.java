public class MagicDictionary3 {
    private String[] dictionary;
    public MagicDictionary3() {
    }

    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }

    public void buildWord(TrieNode node1, TrieNode node2, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (node1.children[s.charAt(i) - 'a'] == null) {
                node1.children[s.charAt(i) - 'a'] = new TrieNode();
            }
            node1 = node1.children[s.charAt(i) - 'a'];
            if (node2.children[s.charAt(s.length() - 1 - i) - 'a'] == null) {
                node2.children[s.charAt(s.length() - 1 - i) - 'a'] = new TrieNode();
            }
            node2 = node2.children[s.charAt(s.length() - 1 - i) - 'a'];
        }
        node1.isWordEnd = true;
        node2.isWordEnd = true;
    }

    public boolean search(String searchWord) {
        TrieNode node1;
        TrieNode node2;
        TrieNode root1 = new TrieNode();
        TrieNode root2 = new TrieNode();
        boolean flag = false;
        for (String s : dictionary) {
            if (!s.equals(searchWord) && s.length() == searchWord.length()) {
                flag = true;
                node1 = root1;
                node2 = root2;
                buildWord(node1, node2, s);
            }
        }
        if (!flag) {
            return false;
        }
        node1 = root1;
        node2 = root2;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < searchWord.length(); i++) {
            if (node1.children[searchWord.charAt(i) - 'a'] == null) {
                break;
            }
            node1 = node1.children[searchWord.charAt(i) - 'a'];
            cnt1++;
        }
        for (int i = 0; i < searchWord.length(); i++) {
            if (node2.children[searchWord.charAt(searchWord.length() - 1 - i) - 'a'] == null) {
                break;
            }
            node2 = node2.children[searchWord.charAt(searchWord.length() - 1 - i) - 'a'];
            cnt2++;
        }
        return cnt1 + cnt2 >= searchWord.length() - 1;
    }
    
    public static void main(String[] args) {
        MagicDictionary3 dic = new MagicDictionary3();
        
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

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
}