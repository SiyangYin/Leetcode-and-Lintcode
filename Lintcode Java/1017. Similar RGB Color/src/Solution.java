import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param color: the given color
     * @return: a 7 character color that is most similar to the given color
     */
    public String similarRGB(String color) {
        // Write your code here
        List<Character> list = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            list.add(i);
        }
        for (char i = 'a'; i <= 'f'; i++) {
            list.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 1; i < color.length(); i += 2) {
            sb.append(getClose(color.substring(i, i + 2), list));
        }
        
        return sb.toString();
    }
    
    private String getClose(String s, List<Character> list) {
        int x = list.indexOf(s.charAt(0)) * 16 + list.indexOf(s.charAt(1));
        StringBuilder sb = new StringBuilder();
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < 16; i++) {
            if (Math.abs(i * 16 + i - x) < dif) {
                dif = Math.abs(i * 16 + i - x);
                sb.setLength(0);
                sb.append(list.get(i)).append(list.get(i));
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println((int) '0');
        System.out.println((int) 'a');
        System.out.println((int) 'A');
    }
}
