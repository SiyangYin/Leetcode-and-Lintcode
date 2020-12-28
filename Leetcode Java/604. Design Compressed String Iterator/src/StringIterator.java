class StringIterator {
    
    private String s;
    private int idx, count;
    private char cur;
    
    public StringIterator(String compressedString) {
        s = compressedString;
    }
    
    public char next() {
        if (!hasNext()) {
            return ' ';
        }
        
        if (count == 0) {
            cur = s.charAt(idx);
            int j = idx + 1;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }
    
            count = Integer.parseInt(s.substring(idx + 1, j));
            idx = j;
        }
        
        count--;
        return cur;
    }
    
    public boolean hasNext() {
        return idx < s.length() || count > 0;
    }
    
    public static void main(String[] args) {
        StringIterator x6 = new StringIterator("x6");
        System.out.println(x6.next());
        System.out.println(x6.next());
        System.out.println(x6.next());
        System.out.println(x6.hasNext());
        System.out.println(x6.next());
        System.out.println(x6.next());
        System.out.println(x6.next());
        System.out.println(x6.next());
        System.out.println(x6.next());
    }
}