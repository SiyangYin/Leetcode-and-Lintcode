public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < n; j += 2 * numRows - 2) {
                    sb.append(s.charAt(j));
                }
            } else {
                for (int j1 = i, j2 = 2 * numRows - 2 - i; j1 < n || j2 < n; j1 += 2 * numRows - 2, j2 += 2 * numRows - 2) {
                    if (j1 < n) {
                        sb.append(s.charAt(j1));
                    }
                    
                    if (j2 < n) {
                        sb.append(s.charAt(j2));
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        
        System.out.println(new Solution().convert(s, numRows));
    }
}
