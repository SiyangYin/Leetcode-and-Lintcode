public class Solution {
    public String toGoatLatin(String sentence) {
        String vow = "aeiouAEIOU";
        
        String[] ss = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            if (vow.indexOf(ss[i].charAt(0)) != -1) {
                sb.append(ss[i]);
            } else {
                sb.append(ss[i].substring(1)).append(ss[i].charAt(0));
            }
    
            sb.append('m').append("a".repeat(i + 2)).append(' ');
        }
        
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().toGoatLatin("I speak Goat Latin"));
    }
}
