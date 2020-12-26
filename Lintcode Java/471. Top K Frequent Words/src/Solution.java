import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if (k == 0) {
            return new String[0];
        }
        
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (!freq.get(s1).equals(freq.get(s2))) {
                return freq.get(s1) < freq.get(s2) ? -1 : 1;
            } else {
                for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
                    if (s1.charAt(i) != s2.charAt(j)) {
                        return s1.charAt(i) > s2.charAt(j) ? -1 : 1;
                    }
                }
                
                return s1.length() > s2.length() ? -1 : 1;
            }
        });
        
        for (String word : freq.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(word);
            } else {
                if (freq.get(word) > freq.get(minHeap.peek()) ||
                        (freq.get(word).equals(freq.get(minHeap.peek())) && word.charAt(0) < minHeap.peek().charAt(0))) {
                    minHeap.poll();
                    minHeap.offer(word);
                }
            }
        }
        
        String[] res = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = minHeap.poll();
        }
        
        return res;
    }
}
