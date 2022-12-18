class Bitset {
    private boolean[] arr;
    private int cnt;
    private boolean flip;
    public Bitset(int size) {
        arr = new boolean[size];
        cnt = 0;
        flip = false;
    }

    public void fix(int idx) {
        if (!flip && !arr[idx]) {
            arr[idx] = true;
            cnt++;
        }
        else if (flip && arr[idx]) {
            arr[idx] = false;
            cnt++;
        }
    }

    public void unfix(int idx) {
        if (!flip && arr[idx]) {
            arr[idx] = false;
            cnt--;
        }
        else if (flip && !arr[idx]) {
            arr[idx] = true;
            cnt--;
        }
    }

    public void flip() {
        flip = !flip;
        cnt = arr.length - cnt;
    }

    public boolean all() {
        return cnt == arr.length;
    }

    public boolean one() {
        return cnt > 0;
    }

    public int count() {
        return cnt;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : arr) {
            if (!flip && b || flip && !b) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Bitset bitset = new Bitset(5);
        bitset.fix(3);
        bitset.fix(1);
        bitset.flip();
        System.out.println(bitset.all());
        bitset.unfix(0);
        bitset.flip();
        System.out.println(bitset.one());
        bitset.unfix(0);
        System.out.println(bitset.count());
        System.out.println(bitset.toString());
    }
}
