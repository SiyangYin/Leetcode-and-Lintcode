public class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        long res = 0;
        if (key == null || key.length == 0) {
            return 0;
        }
        
        for (int i = 0; i < key.length; i++) {
            res = res * 33 + key[i];
            res %= HASH_SIZE;
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hashCode("abcd".toCharArray(), 1000));
    }
}
