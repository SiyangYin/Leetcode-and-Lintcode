public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] a0 = split(a);
        int[] b0 = split(b);
        
        int re = a0[0] * b0[0] - a0[1] * b0[1];
        int im = a0[0] * b0[1] + a0[1] * b0[0];
        StringBuilder sb = new StringBuilder();
        sb.append(re).append('+').append(im).append('i');
        
        return sb.toString();
    }
    
    private int[] split(String num) {
        String[] n = num.split("[+]");
        String n1 = n[0];
        String n2 = n[1];
        return new int[]{Integer.parseInt(n1), Integer.parseInt(n2.substring(0, n2.length() - 1))};
    }
    
    public static void main(String[] args) {
        String a = "1+-1i";
        String b = "1+-1i";
        System.out.println(new Solution().complexNumberMultiply(a, b));
    }
}
