public class Solution2 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        
        System.out.println(new Solution2().convertToTitle(27));
        System.out.println(new Solution2().convertToTitle(25));
        System.out.println(new Solution2().convertToTitle(28));
        System.out.println(new Solution2().convertToTitle(26));
        System.out.println(new Solution2().convertToTitle(701));
    }
}
