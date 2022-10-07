import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1 {
    public int compress(char[] chars) {
        int i = 0, j = 1, cnt = 1;
        while (i < chars.length && j <= chars.length) {
            while (j < chars.length && chars[j] == chars[j - 1]) {
                j++;
                cnt++;
            }
            if(cnt / 10 != 0) {
                Deque<Character> stack = new ArrayDeque<>();
                while (cnt != 0) {
                    stack.push((char)((cnt % 10) + '0'));
                    cnt /= 10;
                }
                while (!stack.isEmpty() && i < chars.length - 1) {
                    chars[++i] = stack.pop();
                }
            }
            i++;
            if (i < chars.length && cnt > 1) {
                chars[i++] = (char)(cnt + '0');
            }
            if (i < chars.length && j < chars.length) {
                chars[i] = chars[j];
            }
            j++;
            cnt = 1;
        }
        return i;
    }
    
    public static void main(String[] args) {
        // char[] chars = "aabbccc".toCharArray();
        char[] chars = "a".toCharArray();
        System.out.println(new Solution1().compress(chars));
    }
}
