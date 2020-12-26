import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> res = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> scores = new HashMap<>();
    
        for (Record record : results) {
            scores.putIfAbsent(record.id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = scores.get(record.id);
            if (pq.size() < 5) {
                pq.offer(record.score);
            } else if (record.score > pq.peek()) {
                pq.poll();
                pq.offer(record.score);
            }
        }
    
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : scores.entrySet()) {
            double ave = 0.0;
            PriorityQueue<Integer> pq = entry.getValue();
            while (!pq.isEmpty()) {
                ave += pq.poll();
            }
            res.put(entry.getKey(), ave / 5.0);
        }
        
        return res;
    }
}

class Record {
    int id, score;
    Record(int id, int score) {
        this.id = id;
        this.score = score;
    }
}