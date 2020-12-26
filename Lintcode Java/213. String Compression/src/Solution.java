public class Solution {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int count;
        for (int i = 0; i < originalString.length(); i++) {
            count = 1;
            while (i + 1 < originalString.length() && originalString.charAt(i) == originalString.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(originalString.charAt(i)).append(count);
        }
        
        return sb.length() < originalString.length() ? sb.toString() : originalString;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().compress("aabcccccaaa"));
        System.out.println(new Solution().compress("aabccccca"));
    }
}
