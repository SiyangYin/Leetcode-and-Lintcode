public class Solution {
    /**
     * @param index: the index to be converted
     * @return: return the string after convert.
     */
    public String convert(long index) {
        // write your code here
        index--;
        StringBuilder sb = new StringBuilder(String.valueOf((index / 702) + 1));
        index %= 702;
        
        if (index / 26 > 0) {
            sb.append((char) ((index / 26) - 1 + 'A'));
        }
        
        sb.append((char) (index % 26 + 'A'));
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().convert(3));
        System.out.println(new Solution().convert(28));
    }
}
