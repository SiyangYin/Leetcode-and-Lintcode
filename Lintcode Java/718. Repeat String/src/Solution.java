public class Solution {
    /**
     * @param A: string A to be repeated
     * @param B: string B
     * @return: the minimum number of times A has to be repeated
     */
    public int repeatedString(String A, String B) {
        // write your code here
        if (A.isEmpty()) {
            return B.isEmpty() ? 0 : -1;
        }
        
        StringBuilder sb = new StringBuilder();
        int res = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            res++;
        }
        
        if (sb.toString().contains(B)) {
            return res;
        }
        
        if (sb.append(A).toString().contains(B)) {
            return res + 1;
        }
        
        return -1;
    }
}
