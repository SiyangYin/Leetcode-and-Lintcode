import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minSetSize(int[] A) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            int j = i;
            while (j < A.length && A[j] == A[i]) {
                j++;
            }
            
            list.add(new int[]{A[i], j - i});
            i = j - 1;
        }
        
        list.sort((x, y) -> -Integer.compare(x[1], y[1]));
        int cnt = 0, res = 0;
        for (int[] p : list) {
            cnt += p[1];
            res++;
            if (cnt >= A.length / 2) {
                return res;
            }
        }
        
        return 0;
    }
}
