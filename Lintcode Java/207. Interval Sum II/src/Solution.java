public class Solution {
    
    class FenwickTree {
        int[] tree;
        
        public FenwickTree(int[] A) {
            tree = new int[A.length + 1];
            for (int i = 0; i < A.length; i++) {
                add(i + 1, A[i]);
            }
        }
        
        void add(int i, int c) {
            while (i < tree.length) {
                tree[i] += c;
                i += lowbit(i);
            }
        }
        
        long sum(int i) {
            long res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            return res;
        }
        
        int lowbit(int x) {
            return x & -x;
        }
    }
    
    
    /* you may need to use some attributes here */
    
    private FenwickTree fenwickTree;
    private int[] A;
    
    /*
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // do intialization if necessary
        fenwickTree = new FenwickTree(A);
        this.A = A;
    }
    
    /*
     * @param start: An integer
     * @param end: An integer
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return fenwickTree.sum(end + 1) - fenwickTree.sum(start);
    }
    
    /*
     * @param index: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void modify(int index, int value) {
        // write your code here
        fenwickTree.add(index + 1, value - A[index]);
        A[index] = value;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 7, 8, 5};
        Solution solution = new Solution(A);
        System.out.println(solution.query(0, 2));
        solution.modify(0,4);
        System.out.println(solution.query(0, 1));
    }
}
