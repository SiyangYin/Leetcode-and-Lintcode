public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: Cosine similarity
     */
    public double cosineSimilarity(int[] A, int[] B) {
        double sumA2 = 0, sumB2 = 0, sAB = 0;
        for (int i = 0; i < A.length; ++i) {
            double a = A[i];
            double b = B[i];
            sAB += a * b;
            sumA2 += a * a;
            sumB2 += b * b;
        }
        
        if (sumA2 == 0 || sumB2 == 0) {
            return 2.0;
        }
        
        return sAB / Math.sqrt(sumA2) / Math.sqrt(sumB2);
    }
}
