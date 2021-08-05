public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int res = 0, idx = 0;
        char[] buf4 = new char[4];
        while (res < n) {
            int x = read4(buf4);
            for (int i = 0; i < x; i++) {
                buf[idx++] = buf4[i];
                if (idx == n) {
                    return idx;
                }
            }
            
            res += x;
            if (x < 4) {
                break;
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