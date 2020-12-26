import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = findClosest(arr, x);
        List<Integer> result = new LinkedList<>();
        result.add(arr[index]);
        
        int left = index, right = index;
        while (result.size() < k) {
            if (left - 1 >= 0 && right + 1 <= arr.length - 1) {
                if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
                    result.add(0, arr[--left]);
                } else {
                    result.add(arr[++right]);
                }
            } else if (left - 1 >= 0) {
                result.add(0, arr[--left]);
            } else {
                result.add(arr[++right]);
            }
        }
        
        return result;
    }
    
    private int findClosest(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;
        System.out.println(new Solution().findClosestElements(arr, k, x));
    }
}
