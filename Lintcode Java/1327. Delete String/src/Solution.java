public class Solution {
    /**
     * @param str: the str
     * @return: the delete positon
     */
    public String deleteString(String str) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        boolean removed = false;
        for (int i = 0; i < str.length(); i++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) > str.charAt(i) && !removed) {
                sb.setLength(sb.length() - 1);
                removed = true;
            }
            
            sb.append(str.charAt(i));
        }
        
        if (!removed) {
            sb.setLength(sb.length() - 1);
        }
        
        return sb.toString();
    }
}
