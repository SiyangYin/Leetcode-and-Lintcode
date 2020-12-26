public class Solution {
    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] left = coeff(split[0]), right = coeff(split[1]);
        int[] coeff = {left[0] - right[0], left[1] - right[1]};
        
        if (coeff[0] == 0) {
            return coeff[1] == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + (-coeff[1] / coeff[0]);
        }
    }
    
    private int[] coeff(String s) {
        if (s.charAt(0) != '-') {
            s = "+" + s;
        }
        
        int[] res = new int[2];
        int coefX = 0, coefC = 0;
        int l = 0, r = 0;
        while (l < s.length()) {
            char ch = s.charAt(l);
            r = l + 1;
            while (r < s.length() && Character.isDigit(s.charAt(r))) {
                r++;
            }
            
            int coef = 0;
            if (r == l + 1) {
                coefX += ch == '+' ? 1 : -1;
            } else {
                int cof = Integer.parseInt(s.substring(l + 1, r));
                coef = ch == '+' ? cof : -cof;
                if (r == s.length() || s.charAt(r) != 'x') {
                    coefC += coef;
                } else {
                    coefX += coef;
                }
            }
            
            if (r == s.length()) {
                break;
            }
            
            l = s.charAt(r) == 'x' ? r + 1 : r;
            
        }
        
        return new int[]{coefX, coefC};
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("x+5-3+x=6+x-2"));
        System.out.println(new Solution().solveEquation("x=x"));
        System.out.println(new Solution().solveEquation("2x=x"));
    }
}
