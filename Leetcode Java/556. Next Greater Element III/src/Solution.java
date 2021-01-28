public class Solution {
    public int nextGreaterElement(int n) {
        char[] chs = String.valueOf(n).toCharArray();
        
        int i = chs.length - 1;
        while (i > 0 && chs[i] <= chs[i - 1]) {
            i--;
        }
        
        if (i == 0) {
            return -1;
        }
        
        int l = i, r = chs.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (chs[m] > chs[i - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        swap(chs, i - 1, l);
        reverse(chs, i, chs.length - 1);
        long res = Long.parseLong(new String(chs));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }
    
    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(char[] chs, int i, int j) {
        char ch = chs[i];
        chs[i] = chs[j];
        chs[j] = ch;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreaterElement(12));
    }
}
