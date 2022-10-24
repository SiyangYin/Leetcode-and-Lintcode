import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers1 {
    private List<Integer> list;
    public ProductOfNumbers1() {
        list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            list.add(1);
        }
        else {
            list.add(list.get(list.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if (k >= list.size()) {
            return 0;
        }
        else {
            return list.get(list.size() - 1) / list.get(list.size() - k - 1);
        }
    }
}