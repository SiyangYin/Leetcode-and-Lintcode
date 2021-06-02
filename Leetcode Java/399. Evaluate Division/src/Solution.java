import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        int size = 0;
        for (List<String> equation : equations) {
            map.putIfAbsent(equation.get(0), size++);
            map.putIfAbsent(equation.get(1), size++);
        }
        
        double[][] mat = new double[size][size];
        for (int i = 0; i < equations.size(); i++) {
            String s1 = equations.get(i).get(0), s2 = equations.get(i).get(1);
            int x = map.get(s1), y = map.get(s2);
            mat[x][x] = mat[y][y] = 1.0;
            mat[x][y] = values[i];
            mat[y][x] = 1 / values[i];
        }
    
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (mat[i][k] != 0 && mat[k][j] != 0) {
                        mat[i][j] = mat[i][k] * mat[k][j];
                    }
                }
            }
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
            int x = map.getOrDefault(s1, -1), y = map.getOrDefault(s2, -1);
            res[i] = x == -1 || y == -1 || mat[x][y] == 0 ? -1 : mat[x][y];
        }
        
        return res;
    }
}
