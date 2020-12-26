import java.util.*;

public class Solution {
    /**
     * @param K:        a integer
     * @param keywords: a list of string
     * @param reviews:  a list of string
     * @return: return the top k keywords list
     */
    public List<String> TopkKeywords(int K, String[] keywords, String[] reviews) {
        // write your code here
        for (int i = 0; i < reviews.length; i++) {
            String review = reviews[i];
            review = review.replaceAll("[\\!?,;.]", "").toLowerCase();
            review = review.replace("[", "");
            review = review.replace("]", "");
            review = review.toLowerCase();
            reviews[i] = " " + review + " ";
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String keyword : keywords) {
            map.put(keyword, 0);
            for (String review : reviews) {
                if (review.contains(" " + keyword + " ")) {
                    map.put(keyword, map.get(keyword) + 1);
                }
            }
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            int f1 = map.get(s1), f2 = map.get(s2);
            if (f1 != f2) {
                return Integer.compare(f1, f2);
            }
            
            return -s1.compareTo(s2);
        });
        
        for (String keyword : keywords) {
            if (minHeap.size() < K) {
                minHeap.offer(keyword);
            } else {
                String top = minHeap.peek();
                if (map.get(keyword) > map.get(top) || (map.get(keyword).equals(map.get(top)) && keyword.compareTo(top) < 0)) {
                    minHeap.poll();
                    minHeap.offer(keyword);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        
        Collections.reverse(res);
        return res;
    }
}
