import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param score: Each student's grades
     * @param ask: A series of inquiries
     * @return: Find the percentage of each question asked
     */
    public List<Integer> englishSoftware(List<Integer> score, List<Integer> ask) {
        // write your code here
        int[] count = new int[101];
        for (int s : score) {
            count[s]++;
        }
        
        int[] preSum = new int[count.length + 1];
        for (int i = 0; i < count.length; i++) {
            preSum[i + 1] = preSum[i] + count[i];
        }
        
        List<Integer> res = new ArrayList<>();
        for (int a : ask) {
            int s = score.get(a - 1);
            res.add((preSum[s + 1] - 1) * 100 / score.size());
        }
        
        return res;
    }
}
