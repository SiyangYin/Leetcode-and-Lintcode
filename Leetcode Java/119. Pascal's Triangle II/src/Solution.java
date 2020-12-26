import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 0; i < rowIndex; i++) {
            row.add(1);
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
//        System.out.println(row);
        return row;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getRow(3));
    }
}