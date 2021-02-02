import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    
    private List<Integer> list;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        int last = list.get(list.size() - 1);
        if (num == 0) {
            list = new ArrayList<>();
            list.add(1);
        } else {
            list.add(num * last);
        }
    }
    
    public int getProduct(int k) {
        int start = list.size() - k;
        if (start <= 0) {
            return 0;
        }
        
        return list.get(list.size() - 1) / list.get(start - 1);
    }
}