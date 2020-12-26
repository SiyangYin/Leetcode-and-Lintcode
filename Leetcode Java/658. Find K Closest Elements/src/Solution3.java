import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // mid-1  mid  mid+1  mid+2  ...  mid+k-1  mid+k
            if (Math.abs(arr[mid] - x) <= Math.abs(arr[mid + k] - x)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(new Solution3().findClosestElements(arr, k, x));
    }
}
