public class Solution1 {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int q = num / 1000;
        int r = num % 1000;
        for (int i = 0; i < q; i++) {
            sb.append("M");
        }
        q = r / 900;
        r = r % 900;
        if (q == 1) {
            sb.append("CM");
        }
        q = r / 500;
        r = r % 500;
        if (q == 1) {
            sb.append("D");
        }
        q = r / 400;
        r = r % 400;
        if (q == 1) {
            sb.append("CD");
        }
        q = r / 100;
        r = r % 100;
        for (int i = 0; i < q; i++) {
            sb.append("C");
        }
        q = r / 90;
        r = r % 90;
        if (q == 1) {
            sb.append("XC");
        }
        q = r / 50;
        r = r % 50;
        if (q == 1) {
            sb.append("L");
        }
        q = r / 40;
        r = r % 40;
        if (q == 1) {
            sb.append("XL");
        }
        q = r / 10;
        r = r % 10;
        for (int i = 0; i < q; i++) {
            sb.append("X");
        }
        q = r / 9;
        r = r % 9;
        if (q == 1) {
            sb.append("IX");
        }
        q = r / 5;
        r = r % 5;
        if (q == 1) {
            sb.append("V");
        }
        q = r / 4;
        r = r % 4;
        if (q == 1) {
            sb.append("IV");
        }
        for (int i = 0; i < r; i++) {
            sb.append("I");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().intToRoman(800));
        System.out.println(new Solution1().intToRoman(900));
    }
}
