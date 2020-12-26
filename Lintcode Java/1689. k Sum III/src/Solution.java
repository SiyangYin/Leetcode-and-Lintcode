import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param a:      the array a
     * @param k:      the integer k
     * @param target: the integer target
     * @return: return the number of legal schemes
     */
    public int getAns(int[] a, int k, int target) {
        // write your code here
        List<Integer> odds = new ArrayList<>(), evens = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0) {
                odds.add(a[i]);
            } else {
                evens.add(a[i]);
            }
        }
        
        odds.sort((x, y) -> -Integer.compare(x, y));
        int posOdd = 0;
        while (posOdd < odds.size() && odds.get(posOdd) + odds.get(odds.size() - 1) > target) {
            posOdd++;
        }
        
        evens.sort((x, y) -> -Integer.compare(x, y));
        int posEven = 0;
        while (posEven < evens.size() && evens.get(posEven) + evens.get(evens.size() - 1) > target) {
            posEven++;
        }
        
        return dfs(posOdd, 0, target, odds, 0, k) + dfs(posEven, 0, target, evens, 0, k);
    }
    
    private int dfs(int pos, int sum, int target, List<Integer> list, int count, int k) {
        if (count == k) {
            if (sum == target) {
                return 1;
            }
            
            return 0;
        }
        
        if (pos == list.size()) {
            return 0;
        }
        
        int res = 0;
        for (int i = pos; i + (k - count) <= list.size(); i++) {
            if (sum + list.get(i) <= target) {
                res += dfs(i + 1, sum + list.get(i), target, list, count + 1, k);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().getAns(new int[]{1, 2, 3, 4}, 2, 4));
        System.out.println(new Solution().getAns(new int[]{10, 10, 9, 1, 8, 2, 7, 3, 6, 4}, 2, 10));
    }
}
