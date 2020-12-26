public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            
            s.append(sum % 2);
            sum /= 2;
        }
        
        if (sum == 1) {
            s.append(1);
        }
        
        return s.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1111", "1111"));
    }
}
