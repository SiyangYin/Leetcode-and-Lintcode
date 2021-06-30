public class Solution {
    /**
     * @param s: a string
     * @return: Is it a valid additive number
     */
    public boolean isAdditiveNumber(String s) {
        // Write your code here
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = i + 1; j < s.length() - 1; j++) {
                int a = 0, b = i + 1, c = j;
                while (true) {
                    String x = s.substring(a, b), y = s.substring(b, c + 1);
                    if (x.length() > 1 && x.charAt(0) == '0' || y.length() > 1 && y.charAt(0) == '0') {
                        break;
                    }
                    
                    String z = add(x, y);
                    int e = c + z.length();
                    if (e >= s.length()) {
                        break;
                    }
                    if (!z.equals(s.substring(c + 1, e + 1))) {
                        break;
                    }
                    
                    if (e == s.length() - 1) {
                        return true;
                    }
                    
                    a = b;
                    b = c + 1;
                    c = e;
                }
            }
        }
        
        return false;
    }
    
    private String add(String x, String y) {
        StringBuilder sb = new StringBuilder();
        int c = 0;
        for (int i = x.length() - 1, j = y.length() - 1; i >= 0 || j >= 0; ) {
            if (i >= 0) {
                c += x.charAt(i--) - '0';
            }
            if (j >= 0) {
                c += y.charAt(j--) - '0';
            }
            
            sb.append(c % 10);
            c /= 10;
        }
        
        if (c == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("112358"));
    }
}
