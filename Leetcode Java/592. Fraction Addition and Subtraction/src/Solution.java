public class Solution {
    
    class Fraction {
        
        private boolean signed;
        private int a, b;
    
        public Fraction(String s) {
            if (s.charAt(0) == '-') {
                signed = true;
                s = s.substring(1);
            }
    
            String[] sp = s.split("/");
            a = Integer.parseInt(sp[0]);
            b = Integer.parseInt(sp[1]);
            reduce();
        }
    
        public Fraction plus(Fraction f) {
            if (signed == f.signed) {
                addAbs(f);
            } else {
                int comp = compareAbs(f);
                if (comp < 0) {
                    signed = !signed;
                    f.minusAbs(this);
                    copyFrom(f);
                } else if (comp > 0) {
                    minusAbs(f);
                } else {
                    a = 0;
                    signed = false;
                }
            }
    
            reduce();
            return this;
        }
        
        private Fraction addAbs(Fraction f) {
            int x = a * f.b + b * f.a;
            int y = b * f.b;
            a = x;
            b = y;
            reduce();
            return this;
        }
        
        private Fraction minusAbs(Fraction f) {
            int x = a * f.b - b * f.a;
            int y = b * f.b;
            a = x;
            b = y;
            reduce();
            return this;
        }
        
        private int compareAbs(Fraction f) {
            int d = a * f.b - b * f.a;
            return Integer.compare(d, 0);
        }
        
        private void reduce() {
            int x = gcd(a, b);
            a /= x;
            b /= x;
        }
        
        private int gcd(int x, int y) {
            return x == 0 ? y : gcd(y % x, x);
        }
        
        private void copyFrom(Fraction f) {
            a = f.a;
            b = f.b;
            signed = f.signed;
        }
    
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (signed) {
                sb.append('-');
            }
            sb.append(a).append('/').append(b);
            return sb.toString();
        }
    }
    
    public String fractionAddition(String expression) {
        Fraction frac = new Fraction("0/1");
        for (int i = 1, j = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || i == expression.length() - 1) {
                String f = expression.substring(j, i == expression.length() - 1 ? expression.length() : i);
                frac.plus(new Fraction(f));
                j = i;
            }
        }
        
        return frac.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().fractionAddition("5/3+1/3"));
    }
}
