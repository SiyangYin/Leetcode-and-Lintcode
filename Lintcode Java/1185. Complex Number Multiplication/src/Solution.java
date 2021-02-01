public class Solution {
    /**
     * @param a: a string
     * @param b: a string
     * @return: a string representing their multiplication
     */
    public String complexNumberMultiply(String a, String b) {
        // Write your code here
        String[] s1 = a.split("\\+");
        int c1Real = Integer.parseInt(s1[0]);
        int c1Comp = Integer.parseInt(s1[1].substring(0, s1[1].length() - 1));
        
        String[] s2 = b.split("\\+");
        int c2Real = Integer.parseInt(s2[0]);
        int c2Comp = Integer.parseInt(s2[1].substring(0, s2[1].length() - 1));
        
        return (c1Real * c2Real - c1Comp * c2Comp) + "+"
                + (c1Real * c2Comp + c1Comp * c2Real) + "i";
    }
}

