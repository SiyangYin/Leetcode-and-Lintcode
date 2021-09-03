import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
    
        // 左端点的范围是[0, n - 1]
        int l = 0, r = arr.length - k;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (x - arr[m] <= arr[m + k] - x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
    
        for (int i = l; i < l + k; i++) {
            res.add(arr[i]);
        }
    
        return res;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(new Solution().findClosestElements(arr, k, x));
    }
}
