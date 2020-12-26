public class Solution {
    /**
     * @param position: the position of circle A,B and point P.
     * @return: if two circle intersect return 1, otherwise -1.
     */
    public int IfIntersect(double[] position) {
        // Write your code here
        double[] A = {position[0], position[1]}, B = {position[3], position[4]}, P = {position[6], position[7]};
        double RA = position[2], RB = position[5];
        if (disSq(A, B) <= sqr(RA + RB)) {
            return 1;
        }
        
        double[] AP = {P[0] - A[0], P[1] - A[1]}, AB = {B[0] - A[0], B[1] - A[1]};
        if (inner(AP, AB) <= 0) {
            return -1;
        }
        
        double shortestDisSqr = inner(AB, AB) - sqr(inner(AB, AP)) / inner(AP, AP);
        
        return shortestDisSqr <= sqr(RA + RB) ? 1 : -1;
    }
    
    private double disSq(double[] A, double[] B) {
        return sqr(A[0] - B[0]) + sqr(A[1] - B[1]);
    }
    
    private double inner(double[] A, double[] B) {
        return A[0] * B[0] + A[1] * B[1];
    }
    
    private double sqr(double d) {
        return d * d;
    }
    
    public static void main(String[] args) {
        double[] p = {0,0,2,5,0,1,0,2};
        System.out.println(new Solution().IfIntersect(p));
    }
}
