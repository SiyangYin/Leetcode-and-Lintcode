class Vector2D {
    
    private int[][] v;
    private int row, col;
    
    public Vector2D(int[][] v) {
        this.v = v;
        row = 0;
        col = -1;
    }
    
    public int next() {
        int[] pos = gotoNext(row, col);
        row = pos[0];
        col = pos[1];
        return v[row][col];
    }
    
    public boolean hasNext() {
        return gotoNext(row, col) != null;
    }
    
    private int[] gotoNext(int row, int col) {
        if (row == v.length) {
            return null;
        }
        
        col++;
        if (col == v[row].length) {
            col = 0;
            row++;
        }
    
        if (row == v.length) {
            return null;
        }
    
        if (v[row].length == 0) {
            while (row < v.length && v[row].length == 0) {
                row++;
            }
        }
        
        return row == v.length ? null : new int[]{row, col};
    }
    
    public static void main(String[] args) {
        // int[][] v = {{1,2}, {3}, {4}};
        // Vector2D it = new Vector2D(v);
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.hasNext());
        // System.out.println(it.hasNext());
        // System.out.println(it.next());
        // System.out.println(it.hasNext());
        
        int[][] v = {{}};
        Vector2D it = new Vector2D(v);
        System.out.println(it.hasNext());
    }
}