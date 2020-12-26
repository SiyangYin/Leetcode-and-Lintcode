import java.util.*;

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.isEmpty()) {
            return 0;
        }
        
        dict.remove(start);
        dict.add(end);
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        
        int len = 1;
        while (!queue.isEmpty()) {
            len++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWordsAndRemove(word, dict)) {
                    if (nextWord.equals(end)) {
                        return len;
                    }
                    
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getNextWordsAndRemove(String word, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c != word.charAt(i)) {
                    String nextWord = replace(word, i, c);
                    if (dict.remove(nextWord)) {
                        nextWords.add(nextWord);
                    }
                }
            }
        }
        
        return nextWords;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
    public static void main(String[] args) {
        String start = "hit", end = "hit";
        Set<String> dict = new HashSet<>() {{
            add("hit");
            add("his");
            add("hot");
        }};
        
        System.out.println(new Solution().ladderLength(start, end, dict));
    }
}
