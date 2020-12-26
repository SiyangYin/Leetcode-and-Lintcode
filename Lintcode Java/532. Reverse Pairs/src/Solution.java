import java.util.Arrays;

public class Solution {
    public long reversePairs(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int count = mergeCount(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        return count;
    }
    
    int mergeCount(int[] a, int start, int end) {
        if (start == end) {
            return 0;
        }
        int sum = 0;
        int mid = start + (end - start) / 2;
        sum += mergeCount(a, start, mid);
        sum += mergeCount(a, mid + 1, end);
        sum += finalMergeCount(a, start, mid, end);
        return sum;
    }
    
    int finalMergeCount(int[] a, int start, int mid, int end) {
        int[] tmp = new int[a.length];
        int sum = 0;
        int index = start;
        int left = start, right = mid + 1;
        while (left <= mid && right <= end) {
            if (a[left] <= a[right]) {
                tmp[index++] = a[left++];
            } else {
                tmp[index++] = a[right++];
                sum += mid - left + 1;
            }
        }
        
        while (left <= mid) {
            tmp[index++] = a[left++];
        }
        while (right <= end) {
            tmp[index++] = a[right++];
        }
        for (int i = start; i <= end; i++) {
            a[i] = tmp[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 1, 3, 5};
        System.out.println(new Solution().reversePairs(a));
    }
}
