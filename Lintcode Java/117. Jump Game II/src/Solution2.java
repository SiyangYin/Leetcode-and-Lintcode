public class Solution2 {
    
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int farthest = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            if (farthest >= A.length - 1) {
                break;
            }
            
            if (i <= farthest) {
                if (farthest < i + A[i]) {
                    farthest = i + A[i];
                    res++;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
