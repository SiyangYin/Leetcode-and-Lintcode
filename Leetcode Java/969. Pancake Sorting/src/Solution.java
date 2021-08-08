import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            int pos = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > arr[pos]) {
                    pos = j;
                }
            }
            
            if (pos == i) {
                continue;
            }
            
            reverse(arr, 0, pos);
            res.add(pos + 1);
            reverse(arr, 0, i);
            res.add(i + 1);
        }
        
        return res;
    }
    
    void reverse(int[] A, int l, int r) {
        for (; l < r; l++, r--) {
            int tmp = A[l];
            A[l] = A[r];
            A[r] = tmp;
        }
    }
}
