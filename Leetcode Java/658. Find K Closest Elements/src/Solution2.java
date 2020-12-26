import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        
        int left = 0, right = arr.length - k;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // mid-1  mid  mid+1  mid+2  ...  mid+k-1  mid+k
            if (Math.abs(arr[mid] - x) <= Math.abs(arr[mid + k] - x)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        int start;
        if (left == right) {
            start = left;
        } else {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[left + k] - x)) {
                start = left;
            } else {
                start = right;
            }
        }
    
        for (int i = start; i < start + k; i++) {
            result.add(arr[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(new Solution2().findClosestElements(arr, k, x));
    }
}
