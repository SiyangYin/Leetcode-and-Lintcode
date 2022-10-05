import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }
        int n = s.length();
        int i = 0, j = 0;
        while(i < n) {
            while(j < numRows - 1 && i < n) {
                list.get(j).add(i);
                i++;
                j++;
            }
            while(j > 0 && i < n) {
                list.get(j).add(i);
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < numRows; l++) {
            for (Integer k : list.get(l)) {
                sb.append(s.charAt(k));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        
        System.out.println(new Solution1().convert(s, numRows));
    }
}
