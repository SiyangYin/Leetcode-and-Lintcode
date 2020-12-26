import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.isEmpty() || !wordList.contains(endWord)) {
            return 0;
        }
        
        wordList.add(beginWord);
        wordList.add(endWord);
        Map<String, Set<String>> graph = buildGraph(wordList);
        
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        Queue<String> beginQueue = new LinkedList<>();
        beginQueue.offer(beginWord);
        Queue<String> endQueue = new LinkedList<>();
        endQueue.offer(endWord);
        
        int path = 2;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int beginSize = beginQueue.size();
            for (int i = 0; i < beginSize; i++) {
                String begin = beginQueue.poll();
                for (String neighbor : graph.get(begin)) {
                    if (endSet.contains(neighbor)) {
                        return path;
                    }
                    if (!beginSet.contains(neighbor)) {
                        beginSet.add(neighbor);
                        beginQueue.offer(neighbor);
                    }
                }
            }
            path++;
            
            int endSize = endQueue.size();
            for (int i = 0; i < endSize; i++) {
                String end = endQueue.poll();
                for (String neighbor : graph.get(end)) {
                    if (beginSet.contains(neighbor)) {
                        return path;
                    }
                    if (!endSet.contains(neighbor)) {
                        endSet.add(neighbor);
                        endQueue.offer(neighbor);
                    }
                }
            }
            
            path++;
        }
        
        return 0;
    }
    
    private Map<String, Set<String>> buildGraph(List<String> wordList) {
        Map<String, Set<String>> graph = new HashMap<>();
        for (String s : wordList) {
            graph.put(s, new HashSet<>());
        }
        
        for (String key : graph.keySet()) {
            char[] word = key.toCharArray();
            for (int i = 0; i < word.length; i++) {
                char c = word[i];
                for (char letter = 'a'; letter <= 'z'; letter++) {
                    if (letter != c) {
                        word[i] = letter;
                        String cur = new String(word);
                        if (graph.containsKey(cur)) {
                            graph.get(key).add(cur);
                        }
                    }
                }
                word[i] = c;
            }
        }
        
        return graph;
    }
    
    
    public static void main(String[] args) {
        String beginWord = "kiss";
        String endWord = "tusk";
        List<String> wordList = new ArrayList<>();
        wordList.add("miss");
        wordList.add("dusk");
        wordList.add("kiss");
        wordList.add("musk");
        wordList.add("tusk");
        wordList.add("diss");
        wordList.add("disk");
        wordList.add("sang");
        wordList.add("ties");
        wordList.add("muss");
        
        System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
    }
}
