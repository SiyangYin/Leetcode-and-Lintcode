import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class Pair {
        int time, flag;
        
        public Pair(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Pair> list = new ArrayList<>();
        for (int[] a : A) {
            list.add(new Pair(a[0], 0));
            list.add(new Pair(a[1], 1));
        }
        for (int[] b : B) {
            list.add(new Pair(b[0], 0));
            list.add(new Pair(b[1], 1));
        }
        
        list.sort((p1, p2) -> p1.time != p2.time ? Integer.compare(p1.time, p2.time) : Integer.compare(p1.flag, p2.flag));
        List<int[]> ans = new ArrayList<>();
        
        int count = 0;
        boolean begin = false;
        for (Pair pair : list) {
            if (pair.flag == 0) {
                count++;
            } else {
                count--;
            }
            
            if (count == 2) {
                ans.add(new int[]{pair.time, pair.time});
                begin = true;
            } else if (begin) {
                ans.get(ans.size() - 1)[1] = pair.time;
                begin = false;
            }
        }
        
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {{0, 2}, {5, 10}}, B = {{1, 5}, {8, 12}};
        System.out.println(Arrays.deepToString(new Solution().intervalIntersection(A, B)));
    }
}
