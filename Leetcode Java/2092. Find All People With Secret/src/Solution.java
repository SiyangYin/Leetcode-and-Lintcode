import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int[] p;
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int first) {
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        
        Arrays.sort(meetings, (x, y) -> Integer.compare(x[2], y[2]));
        p[first] = 0;
        for (int i = 0; i < meetings.length; i++) {
            int j = i;
            while (j < meetings.length && meetings[j][2] == meetings[i][2]) {
                int x = meetings[j][0], y = meetings[j][1];
                p[find(x)] = find(y);
                j++;
            }
            int p0 = find(0);
            j = i;
            while (j < meetings.length && meetings[j][2] == meetings[i][2]) {
                int x = meetings[j][0], y = meetings[j][1];
                if (find(x) != p0 && find(y) != p0) {
                    p[x] = x;
                    p[y] = y;
                }
                j++;
            }
            i = j - 1;
        }
        
        List<Integer> res = new ArrayList<>();
        int p0 = find(0);
        for (int i = 0; i < n; i++) {
            if (find(i) == p0) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[][] meetings = {{3, 1, 3}, {1, 2, 2}, {0, 3, 3}};
        int first = 3;
        System.out.println(new Solution().findAllPeople(n, meetings, first));
    }
}
