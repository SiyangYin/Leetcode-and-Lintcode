import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            int f1 = frequency.get(s1), f2 = frequency.get(s2);
            if (f1 < f2) {
                return -1;
            } else if (f1 > f2) {
                return 1;
            } else {
                return -s1.compareTo(s2);
            }
        });
    
        for (String word : frequency.keySet()) {
            if (pq.size() < k) {
                pq.offer(word);
            } else {
                int f1 = frequency.get(word), f2 = frequency.get(pq.peek());
                if (f1 > f2 || (f1 == f2 && word.compareTo(pq.peek()) < 0)) {
                    pq.poll();
                    pq.offer(word);
                }
            }
        }
        
        List<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(0, pq.poll());
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(new Solution().topKFrequent(words, 2));
    }
}
