public class Solution {
    /**
     * @param matrix: The 3*3 matrix
     * @return: The answer
     */
    public String jigsawPuzzle(int[][] matrix) {
        // Write your code here
        return (computeInversePairs(matrix) & 1) == 0 ? "YES" : "NO";
    }
    
    private int computeInversePairs(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
            }
        }
        
        int count = 0;
        for (int i = 1; i < sb.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (sb.charAt(i) == '0' || sb.charAt(j) == '0') {
                    continue;
                }
                
                if (sb.charAt(j) > sb.charAt(i)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        System.out.println(new Solution().computeInversePairs(m));
    }
}
