import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
                triangle.add(row);
            } else {
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(triangle.get(i - 1).get(j) + triangle.get(i - 1).get(j - 1));
                    }
                }
                triangle.add(row);
            }
        }
        return triangle;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generate(0));
    }
}
