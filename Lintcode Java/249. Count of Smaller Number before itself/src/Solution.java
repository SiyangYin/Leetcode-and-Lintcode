import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class FenwickTree {
        private int[] tree;
    
        public FenwickTree(int n) {
            tree = new int[n];
        }
        
        public void add(int i, int x) {
            while (i < tree.length) {
                tree[i] += x;
                i += lowbit(i);
            }
        }
        
        public int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            
            return res;
        }
        
        private int lowbit(int x) {
            return x & -x;
        }
    }
    
    /**
     * @param A: an integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        int max = 0;
        for (int i : A) {
            max = Math.max(max, i);
        }
        
        FenwickTree fenwickTree = new FenwickTree(max + 2);
        for (int i = 0; i < A.length; i++) {
            fenwickTree.add(A[i] + 1, 1);
            res.add(fenwickTree.sum(A[i]));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 7, 8, 5};
        System.out.println(new Solution().countOfSmallerNumberII(A));
    }
}
