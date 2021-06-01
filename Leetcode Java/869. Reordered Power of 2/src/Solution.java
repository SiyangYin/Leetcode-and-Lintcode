import java.util.Arrays;

public class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
    
        for (int i = 0; i < 30; i++) {
            if (Arrays.equals(cnt, get(1 << i))) {
                return true;
            }
        }
        
        return false;
    }
    
    private int[] get(int x) {
        int[] res = new int[10];
        while (x > 0) {
            res[x % 10]++;
            x /= 10;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(1 << 29);
        System.out.println((int) 1e9);
    }
}
