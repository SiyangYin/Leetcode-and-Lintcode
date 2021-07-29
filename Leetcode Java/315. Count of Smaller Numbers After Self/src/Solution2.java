import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n], idxs = new int[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        
        mergeSort(0, n - 1, cnt, idxs, nums, new int[n]);
        
        List<Integer> res = new ArrayList<>();
        for (int x : cnt) {
            res.add(x);
        }
        
        return res;
    }
    
    private void mergeSort(int l, int r, int[] cnt, int[] idxs, int[] nums, int[] tmp) {
        if (l >= r) {
            return;
        }
        
        int mid = l + (r - l >> 1);
        mergeSort(l, mid, cnt, idxs, nums, tmp);
        mergeSort(mid + 1, r, cnt, idxs, nums, tmp);
        merge(l, r, mid, idxs, cnt, nums, tmp);
    }
    
    private void merge(int l, int r, int mid, int[] idxs, int[] cnt, int[] nums, int[] tmp) {
        int i = l, j = mid + 1, pos = l;
        while (i <= mid && j <= r) {
            if (nums[idxs[i]] <= nums[idxs[j]]) {
                cnt[idxs[i]] += j - mid - 1;
                tmp[pos++] = idxs[i++];
            } else {
                tmp[pos++] = idxs[j++];
            }
        }
        
        while (i <= mid) {
            cnt[idxs[i]] += j - mid - 1;
            tmp[pos++] = idxs[i++];
        }
        while (j <= r) {
            tmp[pos++] = idxs[j++];
        }
        
        for (int k = l; k <= r; k++) {
            idxs[k] = tmp[k];
        }
    }
}