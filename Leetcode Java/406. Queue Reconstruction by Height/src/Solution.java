import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ?
                -Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        List<int[]> list = new ArrayList<>();
        for (int[] cur : people) {
            list.add(cur[1], cur);
        }
        
        int[][] res = new int[people.length][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] p = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(new Solution().reconstructQueue(p)));
    }
}
