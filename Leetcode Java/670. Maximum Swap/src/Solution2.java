import java.util.Arrays;

public class Solution2 {
    public int maximumSwap(int num) {
        char[] n = String.valueOf(num).toCharArray();
        char[] tmp = Arrays.copyOf(n, n.length);
        
        Arrays.sort(tmp);
        flip(tmp);
    
        int j = -1, swap = -1;
        for (int i = 0; i < n.length; i++) {
            if (n[i] != tmp[i]) {
                j = i;
                swap = tmp[i];
                break;
            }
        }
        
        if (j == -1) {
            return num;
        }
    
        for (int i = n.length - 1; i >= 0; i--) {
            if (n[i] == swap) {
                swap(n, i, j);
                break;
            }
        }
        
        return Integer.parseInt(new String(n));
    }
    
    private void flip(char[] chs) {
        int i = 0, j = chs.length - 1;
        while (i < j) {
            swap(chs, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
