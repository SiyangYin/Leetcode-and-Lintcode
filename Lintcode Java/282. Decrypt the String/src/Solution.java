public class Solution {
    /**
     * @param Message: the string xiao Q sent to xiao A.
     * @return: the string after decompress
     */
    public String DecompressString(String Message) {
        // write your code here
        if (Message == null || Message.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Message.length(); i++) {
            char c = Message.charAt(i);
            if (c != ']') {
                sb.append(c);
            } else {
                int j = sb.length() - 1;
                while (sb.charAt(j) != '|') {
                    j--;
                }
                String repeat = sb.substring(j + 1);
                
                int k = j - 1;
                while (Character.isDigit(sb.charAt(k))) {
                    k--;
                }
                int count = Integer.parseInt(sb.substring(k + 1, j));
                
                sb.setLength(k);
                for (int l = 0; l < count; l++) {
                    sb.append(repeat);
                }
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().DecompressString("HG[3|B[2|CA]]F"));
        System.out.println(new Solution().DecompressString("HG[3|B[2|CA[2|R]]TC]F"));
    }
}
