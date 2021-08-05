import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param equations:
     * @param values:
     * @param queries:
     * @return: return a double type array
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // write your code here
        int idx = 0;
        Map<String, Integer> id = new HashMap<>();
        for (List<String> equation : equations) {
            String x = equation.get(0), y = equation.get(1);
            if (!id.containsKey(x)) {
                id.put(x, idx++);
            }
            if (!id.containsKey(y)) {
                id.put(y, idx++);
            }
        }
        
        double[][] mat = new double[idx][idx];
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String x = equation.get(0), y = equation.get(1);
            mat[id.get(x)][id.get(y)] = values[i];
            mat[id.get(y)][id.get(x)] = 1 / values[i];
            mat[id.get(x)][id.get(x)] = 1;
            mat[id.get(y)][id.get(y)] = 1;
        }
        
        for (int k = 0; k < id.size(); k++) {
            for (int i = 0; i < id.size(); i++) {
                for (int j = 0; j < id.size(); j++) {
                    if (mat[i][k] != 0 && mat[k][j] != 0) {
                        mat[i][j] = mat[i][k] * mat[k][j];
                    }
                }
            }
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String x = query.get(0), y = query.get(1);
            if (!id.containsKey(x) || !id.containsKey(y) || mat[id.get(x)][id.get(y)] == 0) {
                res[i] = -1;
            } else {
                res[i] = mat[id.get(x)][id.get(y)];
            }
        }
        
        return res;
    }
}
