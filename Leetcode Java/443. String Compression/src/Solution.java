public class Solution {
    public int compress(char[] chars) {
        char letter = chars[0];
        int count = 0;
    
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == letter) {
                count++;
            } else {
                index = replace(chars, letter, index, count);
                letter = chars[i];
                count = 0;
                i--;
            }
        }
        
        index = replace(chars, letter, index, count);
    
        return index;
    }
    
    private int replace(char[] chars, char letter, int index, int count) {
        chars[index++] = letter;
        if (count > 1) {
            String charCount = String.valueOf(count);
            for (int j = 0; j < charCount.length(); j++) {
                chars[index++] = charCount.charAt(j);
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        // char[] chars = "aabbccc".toCharArray();
        char[] chars = "a".toCharArray();
        System.out.println(new Solution().compress(chars));
    }
}
