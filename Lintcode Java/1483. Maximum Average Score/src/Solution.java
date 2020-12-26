import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param names: the name
     * @param grades: the grade
     * @return: the maximum average score
     */
    public double maximumAverageScore(List<String> names, int[] grades) {
        // Write your code here
        Map<String, double[]> map = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            map.putIfAbsent(name, new double[]{0, 0});
            
            double[] scores = map.get(name);
            scores[0] += 1;
            scores[1] += grades[i];
        }
     
        double res = 0;
        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            double[] scores = entry.getValue();
            res = Math.max(res, scores[1] / scores[0]);
        }
        
        return res;
    }
}
