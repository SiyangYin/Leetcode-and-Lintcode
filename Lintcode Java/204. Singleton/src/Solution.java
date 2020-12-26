class Solution {
    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        // write your code here
        return instance;
    }
    
    private Solution() {
    
    }
    
    private static Solution instance = new Solution();
    
};

