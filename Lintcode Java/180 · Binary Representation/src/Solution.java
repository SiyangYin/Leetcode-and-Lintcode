public class Solution {
    
    class Fraction {
        long a, b;
        
        public Fraction(long a, long b) {
            this.a = a;
            this.b = b;
            cancel();
        }
        
        public Fraction minus(long a, long b) {
            long x = this.a * b - this.b * a, y = this.b * b;
            this.a = x;
            this.b = y;
            cancel();
            return this;
        }
        
        public boolean greater(long a, long b) {
            return this.a * b >= this.b * a;
        }
        
        private void cancel() {
            long g = gcd(a, b);
            a /= g;
            b /= g;
        }
        
        private long gcd(long x, long y) {
            return y == 0 ? x : gcd(y, x % y);
        }
    }
    
    /**
     * @param n: Given a decimal number that is passed in as a string
     * @return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        String[] split = n.split("\\.");
        
        long a = Long.parseLong(split[0]);
        if (a > 0) {
            while (a > 0) {
                sb.append(a % 2);
                a >>= 1;
            }
        } else {
            sb.append(0);
        }
        
        sb.reverse();
        if (split.length < 2) {
            return sb.toString();
        }
        
        sb.append('.');
        long b = Long.parseLong(split[1]);
        Fraction cur = new Fraction(b, (long) Math.pow(10, split[1].length()));
        for (long i = 2, l = 0; cur.a > 0 && l <= 32; i <<= 1, l++) {
            if (cur.greater(1, i)) {
                cur = cur.minus(1, i);
                sb.append(1);
            } else {
                sb.append(0);
            }
        }
        
        if (sb.charAt(sb.length() - 1) == '.') {
            sb.setLength(sb.length() - 1);
        }
        
        return cur.a == 0 ? sb.toString() : "ERROR";
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().binaryRepresentation("3.5"));
        // System.out.println(Long.parseLong("6418609619140625"));
        // System.out.println(Long.parseLong("10000000000000000"));
        System.out.println(new Solution().binaryRepresentation("0"));
        System.out.println("1000011111101111011000111.1010010001010001".length());
    }
}
