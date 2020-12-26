public class Solution {
    /**
     * @param matrix: List[List[int]]
     * @param k:      a integer
     * @return: return a integer
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        
        while (l < r) {
            int mid = l + (r - l >> 1);
            int count = 0;
            int x = n - 1, y = 0;
            while (x >= 0 && y < n) {
                if (matrix[x][y] <= mid) {
                    count += x + 1;
                    y++;
                } else {
                    x--;
                }
            }
            
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
                {1, 3, 5},
                {6, 7, 12},
                {11, 14, 14}};
        System.out.println(new Solution().kthSmallest(mat, 5));
    }
}
