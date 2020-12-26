public class Solution {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        int min = Integer.MIN_VALUE, index = -1;
        for (int num : preorder) {
            if (num < min) {
                return false;
            }
            
            while (index >= 0 && num > preorder[index]) {
                min = preorder[index--];
            }
            
            preorder[++index] = num;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().verifyPreorder(new int[]{1, 3, 2}));
    }
}
