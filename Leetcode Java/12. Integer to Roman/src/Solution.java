public class Solution {
    public String intToRoman(int num) {
        String[] rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            while (num >= number[i]) {
                sb.append(rome[i]);
                num -= number[i];
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(800));
        System.out.println(new Solution().intToRoman(900));
    }
}
