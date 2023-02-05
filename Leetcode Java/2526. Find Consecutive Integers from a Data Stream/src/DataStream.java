class DataStream {
    private int value;
    private int k;
    private int cnt;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        cnt = 0;
    }

    public boolean consec(int num) {
        cnt = num == value ? cnt + 1 : 0;
        return cnt >= k ? true : false;
    }

    public static void main(String[] args) {
        DataStream dataStream = new DataStream(4, 3);
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(3));
    }
}
