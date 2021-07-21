import java.util.Arrays;

public class Solution {
    /**
     * @param n: length of sequence
     * @param q: Operating frequency
     * @param a: the sequence
     * @param b: the standard of each operation
     * @return: How many numbers are subtracted by one after each operation
     */
    public int[] sequenceMaintenance(int n, int q, int[] a, int[] b) {
        // write your code here
        Arrays.sort(a);
        int len = (int) Math.sqrt(n);
        int[] lazy = new int[n % len == 0 ? n / len : n / len + 1];
        
        int[] res = new int[q];
        for (int i = 0; i < b.length; i++) {
            int bi = b[i];
            int pos = binarySearch(a, lazy, bi, len);
            if (pos == -1) {
                res[i] = 0;
            } else {
                res[i] = n - pos;
                update(a, lazy, pos, len);
            }
        }
        
        return res;
    }
    
    private void update(int[] a, int[] lazy,int pos, int len) {
        int i = pos, j = a.length - 1;
        if (getBlock(i, len) == getBlock(j, len)) {
            for (int k = i; k <= j; k++) {
                a[k]--;
            }
        } else {
            while (getBlock(i, len) == getBlock(pos, len)) {
                a[i++]--;
            }
            while (getBlock(j, len) == getBlock(a.length - 1, len)) {
                a[j--]--;
            }
            for (int k = getBlock(i, len); k <= getBlock(j, len); k++) {
                lazy[k]++;
            }
        }
    }
    
    private int binarySearch(int[] a, int[] lazy, int bi, int len) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (a[m] - lazy[getBlock(m, len)] >= bi) {
                r = m;
            } else {
                l = m + 1;
            }
        }
    
        return  a[l] - lazy[getBlock(l, len)] >= bi ? l : -1;
    }
    
    private int getBlock(int i, int len) {
        return i / len;
    }
    
    public static void main(String[] args) {
        int n = 3, q = 2;
        int[] a = {1,2,3}, b = {3,3};
        System.out.println(Arrays.toString(new Solution().sequenceMaintenance(n, q, a, b)));
    }
}
