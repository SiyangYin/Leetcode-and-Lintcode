public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                if (numbers[g - '0'] > 0) {
                    cows++;
                }
                if (numbers[s - '0'] < 0) {
                    cows++;
                }
                numbers[s - '0']++;
                numbers[g - '0']--;
            }
        }
        return bulls + "A" + cows + "B";
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1122", "2211"));
    }
}
