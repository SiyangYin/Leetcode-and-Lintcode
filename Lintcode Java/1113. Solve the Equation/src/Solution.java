import java.util.Arrays;

public class Solution {
    /**
     * @param equation: a string
     * @return: return a string
     */
    public String solveEquation(String equation) {
        // write your code here
        String[] s = equation.split("=");
        String left = s[0];
        String right = s[1];
        int[] leftPair = parseExpression(left);
        int[] rightPair = parseExpression(right);
        int[] finalPair = new int[]{leftPair[0] - rightPair[0], leftPair[1] - rightPair[1]};
        if (finalPair[0] == 0) {
            if (finalPair[1] == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + (-(finalPair[1] / finalPair[0]));
    }
    
    //  return the coefficient of x and constant
    private int[] parseExpression(String expression) {
        int coefficient = 0;
        int constant = 0;
        String term = "";
        if (!expression.startsWith("+") && !expression.startsWith("-")) {
            expression = "+" + expression;
        }
        term += expression.charAt(0);
        for (int i = 1; i < expression.length(); i++) {
            if (expression.charAt(i) != '+' && expression.charAt(i) != '-') {
                term += expression.charAt(i);
            }
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || i == expression.length() - 1){
                int[] pair = parseTerm(term);
                coefficient += pair[0];
                constant += pair[1];
                term = "" + expression.charAt(i);
            }
        }
        return new int[]{coefficient, constant};
    }
    
    //  return the coefficient and constant pair
    private int[] parseTerm(String term) {
        int[] pair = new int[2];
        if (term.equals("+x")) {
            pair[0] = 1; pair[1] = 0;
            return pair;
        }
        if (term.equals("-x")) {
            pair[0] = -1; pair[1] = 0;
            return pair;
        }
        
        if (term.endsWith("x")) {
            pair[0] = Integer.parseInt(term.substring(1, term.length()  - 1));
            if (term.startsWith("-")) {
                pair[0] = -pair[0];
            }
        } else {
            pair[1] = Integer.parseInt(term.substring(1, term.length()));
            if (term.startsWith("-")) {
                pair[1] = -pair[1];
            }
        }
        return pair;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("-x+x+3x=2x-x+x"));
    }
}