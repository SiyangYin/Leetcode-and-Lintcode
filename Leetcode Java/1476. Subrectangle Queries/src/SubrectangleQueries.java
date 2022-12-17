import java.util.ArrayList;
import java.util.List;

class SubrectangleQueries {
    private int[][] rectangle;
    private List<int[]> list;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        list = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        list.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (row >= list.get(i)[0] && row <= list.get(i)[2] && col >= list.get(i)[1] && col <= list.get(i)[3]) {
                return list.get(i)[4];
            }
        }
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1,2,1},{4,3,4},{3,2,1},{1,1,1}});
        System.out.println(subrectangleQueries.getValue(0,2));
        subrectangleQueries.updateSubrectangle(0,0,3,2,5);
        System.out.println(subrectangleQueries.getValue(0,2));
        System.out.println(subrectangleQueries.getValue(3,1));
        subrectangleQueries.updateSubrectangle(3,0,3,2,10);
        System.out.println(subrectangleQueries.getValue(3,1));
        System.out.println(subrectangleQueries.getValue(0,2));
    }
}