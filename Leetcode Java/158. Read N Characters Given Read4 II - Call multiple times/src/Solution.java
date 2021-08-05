public class Solution extends Reader4 {
    
    private char[] buffer = new char[4];
    private int head, tail;
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int res = 0;
        while (res < n) {
            if (head == tail) {
                head = 0;
                tail = read4(buffer);
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
}

class Reader4 {
    int read4(char[] buf4) {
        return 0;
    }
}