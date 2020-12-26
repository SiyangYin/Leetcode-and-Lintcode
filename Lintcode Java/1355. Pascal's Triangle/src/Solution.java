import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param numRows: num of rows
     * @return: generate Pascal's triangle
     */
    public List<List<Integer>> generate(int numRows) {
        // write your code here
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(triangle.get(i - 1).get(j - 1) +
                            triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().generate(3));
    }
}