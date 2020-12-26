public class Solution {
    /**
     * @param A: the integer discrible in problem
     * @return: the integer after distortion
     */
    public String Distortion(String A) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        int i = 0, j = A.length() - 1;
        while (i < j) {
            sb.append(A.charAt(j--));
            sb.append(A.charAt(i++));
        }
        
        if (A.length() % 2 != 0) {
            sb.append(A.charAt(i));
        }
        
        return sb.toString();
    }
}
