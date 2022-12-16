import java.util.HashMap;
import java.util.Map;

class Cashier {
    private int n;
    private double d;
    private int i;
    private Map<Integer, Integer> map;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.d = discount;
        i = 1;
        map = new HashMap<>();
        for (int j = 0; j < products.length; j++) {
            map.put(products[j], prices[j]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        double res = 0;
        for (int j = 0; j < product.length; j++) {
            res += map.get(product[j]) * amount[j];
        }
        if (i++ % n == 0) {
            res = res * (1 - d / 100);
        }
        return res;
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier(3,50, new int[]{1,2,3,4,5,6,7}, new int[]{100,200,300,400,300,200,100});
        System.out.println(cashier.getBill(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(cashier.getBill(new int[]{3, 7}, new int[]{10, 10}));
        System.out.println(cashier.getBill(new int[]{1,2,3,4,5,6,7}, new int[]{1,1,1,1,1,1,1}));
        System.out.println(cashier.getBill(new int[]{4}, new int[]{10}));
        System.out.println(cashier.getBill(new int[]{7, 3}, new int[]{10, 10}));
        System.out.println(cashier.getBill(new int[]{7,5,3,1,6,4,2}, new int[]{10,10,10,9,9,9,7}));
        System.out.println(cashier.getBill(new int[]{2,3,5}, new int[]{5,3,2}));
    }
}
