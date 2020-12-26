import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String decodeString(String s) {
        Deque<String> strings = new LinkedList<>();
        Deque<Integer> numbers = new LinkedList<>();
        StringBuilder res = new StringBuilder();
    
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n *= 10;
                    n += s.charAt(i++) - '0';
                }
                numbers.push(n);
                i--;
            } else {
                if (s.charAt(i) == '[' || s.charAt(i) == ']') {
                    strings.push(String.valueOf(s.charAt(i)));
                } else {
                    StringBuilder str = new StringBuilder();
                    while (i < s.length() && Character.isLetter(s.charAt(i))) {
                        str.append(s.charAt(i));
                        i++;
                    }
                    i--;
                    strings.push(str.reverse().toString());
                }
            }
            
            if (!strings.isEmpty() && "]".equals(strings.peek())) {
                strings.pop();
                StringBuilder sb = new StringBuilder();
                while (!"[".equals(strings.peek())) {
                    sb.append(strings.pop());
                }
                strings.pop();
                
                strings.push(sb.toString().repeat(numbers.pop()));
            }
        }
    
        while (!strings.isEmpty()) {
            res.append(strings.pop());
        }
        
        return res.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("cc3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
        System.out.println(new Solution().decodeString("10[a]"));
        System.out.println(new Solution().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
