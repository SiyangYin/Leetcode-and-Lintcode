public class Solution {
    /**
     * @param str: An array of char
     * @param left: a left offset
     * @param right: a right offset
     * @return: return a rotate string
     */
    public String RotateString2(String str, int left, int right) {
        // write your code here
        int pos = (right - left) % str.length();
        if (pos < 0) {
            pos += str.length();
        }
        char[] s = str.toCharArray();
        flip(s, 0, s.length - 1);
        flip(s, 0, pos - 1);
        flip(s, pos, s.length - 1);
        return new String(s);
    }
    
    public void flip(char[] arr, int left, int right) {
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++; right--;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().RotateString2("abcdefg", 3, 1));
    }
}