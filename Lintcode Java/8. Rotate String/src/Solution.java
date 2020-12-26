public class Solution {
    /**
     * @param str:    An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        
        offset %= str.length;
        
        reverse(str, 0, str.length - 1);
        reverse(str, 0, offset - 1);
        reverse(str, offset, str.length - 1);
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            swap(str, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
    
    public static void main(String[] args) {
        char[] str = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        new Solution().rotateString(str, 3);
        System.out.println(str);
    }
}
