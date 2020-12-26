public class Solution {
    /**
     * @param s: a string
     * @return: return a string
     */
    public String reverseString(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return s;
        }
    
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            swap(arr, i, j);
        }
    
        return new String(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
