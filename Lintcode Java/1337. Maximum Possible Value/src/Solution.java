public class Solution {
    /**
     * @param N: an integer
     * @return: returns the maximum possible value obtained by inserting one '5' digit
     */
    public int MaximumPossibleValue(int N) {
        // write your code here
        if (N == 0) {
            return 50;
        }
        
        StringBuilder sb = new StringBuilder();
        String num = String.valueOf(N);
        boolean inserted = false;
        if (num.charAt(0) != '-') {
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch < '5' && !inserted) {
                    sb.append(5);
                    inserted = true;
                }
                sb.append(ch);
            }
    
            if (!inserted) {
                sb.append(5);
            }
        } else {
            num = num.substring(1);
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch > '5' && !inserted) {
                    sb.append(5);
                    inserted = true;
                }
                sb.append(ch);
            }
    
            if (!inserted) {
                sb.append(5);
            }
            
            sb.insert(0, '-');
        }
    
        return Integer.parseInt(sb.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MaximumPossibleValue(268));
        System.out.println(new Solution().MaximumPossibleValue(-268));
    }
}
