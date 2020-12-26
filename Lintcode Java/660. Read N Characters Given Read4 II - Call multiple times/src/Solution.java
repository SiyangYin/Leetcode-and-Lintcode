public class Solution extends Reader4 {
    
    private char[] buffer = new char[4];
    private int head, tail;
    
    /**
     * @param buf destination buffer
     * @param n   maximum number of characters to read
     * @return the number of characters read
     */
    public int read(char[] buf, int n) {
        // Write your code here
        int res = 0;
        
        while (res < n) {
            if (head == tail) {
                tail = read4(buffer);
                head = 0;
            }
            
            if (tail == 0) {
                break;
            }
            
            while (res < n && head < tail) {
                buf[res++] = buffer[head++];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.read("filetestbuffer".toCharArray(), 6));
        System.out.println(sol.read("filetestbuffer".toCharArray(), 5));
        System.out.println(sol.read("filetestbuffer".toCharArray(), 3));
        System.out.println(sol.read("filetestbuffer".toCharArray(), 2));
    }
}

class Reader4 {
    int read4(char[] buf) {
        return 0;
    }
}