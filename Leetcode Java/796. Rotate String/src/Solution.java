class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        
        return (A + A).contains(B);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().rotateString("", ""));
        System.out.println(new Solution().rotateString("abcde", "eabcd"));
        
    }
}