import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param rowIndex: a non-negative index
     * @return: the kth index row of the Pascal's triangle
     */
    public List<Integer> getRow(int rowIndex) {
        // write your code here
        List<Integer> row1 = new ArrayList<>(), row2 = new ArrayList<>();
        row1.add(1);
        row2.add(1);
        row2.add(1);
        
        if (rowIndex == 0) {
            return row1;
        }
        if (rowIndex == 1) {
            return row2;
        }
    
        for (int i = 0; i < rowIndex - 1; i++) {
            row1.add(0);
            for (int j = 1; j < row2.size(); j++) {
                row1.set(j, row2.get(j - 1) + row2.get(j));
            }
            row1.add(1);
            List<Integer> swap = row1;
            row1 = row2;
            row2 = swap;
        }
        
        return row2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(4));
    }
}
