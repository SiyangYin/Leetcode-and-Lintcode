import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param votes: The array of names of candidates in the election.
     * @return: The name of the candidate who has the most votes.
     */
    public String candidateWithTheMostVotes(List<String> votes) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String vote : votes) {
            map.put(vote, map.getOrDefault(vote, 0) + 1);
            max = Math.max(max, map.get(vote));
        }
        
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                if (res.isEmpty() || res.compareTo(entry.getKey()) > 0) {
                    res = entry.getKey();
                }
            }
        }
        
        return res;
    }
    
    
}
