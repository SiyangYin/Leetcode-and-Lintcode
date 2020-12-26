public class Solution {
    /**
     * @param A: An integer
     * @return: a float number
     */
    public float maxOfArray(float[] A) {
        // write your code here
        float res = -Float.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (res < A[i]) {
                res = A[i];
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        float res = -Float.MAX_VALUE;
        
        System.out.println(res);
    }
}
