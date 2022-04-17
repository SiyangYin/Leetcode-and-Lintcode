import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    
    Map<Integer, Integer> map;
    int m, n, total;
    Random rand;
    
    public Solution(int m, int n) {
        map = new HashMap<>();
        rand = new Random();
        this.m = m;
        this.n = n;
        total = m * n;
    }
    
    public int[] flip() {
        int x = rand.nextInt(total--);
        int y = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(total, total));
        map.put(total, y);
        return new int[]{y / n, y % n};
    }
    
    public void reset() {
        total = m * n;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution(3, 1);
        System.out.println(Arrays.toString(sol.flip()));
        System.out.println(Arrays.toString(sol.flip()));
        System.out.println(Arrays.toString(sol.flip()));
        sol.reset();
        System.out.println(Arrays.toString(sol.flip()));
    }
}
