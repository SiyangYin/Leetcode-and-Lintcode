import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        
        while (list.size() < N) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : list) {
                if (num * 2 - 1 <= N) {
                    tmp.add(num * 2 - 1);
                }
            }
            
            for (int num : list) {
                if (num * 2 <= N) {
                    tmp.add(num * 2);
                }
            }
            
            list = tmp;
        }
        
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().beautifulArray(5)));
    }
}
