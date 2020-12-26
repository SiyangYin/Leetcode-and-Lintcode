public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        if (chars == null || chars.length == 0) {
            return;
        }
        
        int left = 0, right = chars.length - 1;
        while (left < right) {
            while (Character.isLowerCase(chars[left]) && left < right) {
                left++;
            }
            
            while (Character.isUpperCase(chars[right]) && left < right) {
                right--;
            }
            
            swap(chars, left, right);
        }
        
    }
    
    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
    
    public static void main(String[] args) {
        char[] chars = "abAcD".toCharArray();
        new Solution().sortLetters(chars);
    
        System.out.println(chars);
    }
}