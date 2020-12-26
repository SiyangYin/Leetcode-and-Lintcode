public class Solution {
    /**
     * @param letters: a list of sorted characters
     * @param target: a target letter
     * @return: the smallest element in the list that is larger than the given target
     */
    public char nextGreatestLetter(char[] letters, char target) {
        // Write your code here
        int left = 0, right = letters.length - 1;
        while (left < right) {
            int mid = left + (right - left >> 1);
            char c = letters[mid];
            if (c <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return letters[left] > target ? letters[left] : letters[0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }
}
