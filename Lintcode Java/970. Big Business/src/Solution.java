import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class Movie {
        int cost, price;
        
        public Movie(int cost, int price) {
            this.cost = cost;
            this.price = price;
        }
    }
    
    /**
     * @param a: The cost of the film
     * @param b: The price of the selling of the film
     * @param k: The principal
     * @return: The answer
     */
    public int bigBusiness(int[] a, int[] b, int k) {
        // Write your code here
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) {
                movies.add(new Movie(a[i], b[i]));
            }
        }
        
        movies.sort((m1, m2) -> Integer.compare(m1.cost, m2.cost));
    
        for (Movie movie : movies) {
            if (k >= movie.cost) {
                k += movie.price - movie.cost;
            } else {
                break;
            }
        }
        
        return k;
    }
    
    public static void main(String[] args) {
        int[] a = {3, 1, 5}, b = {4, 3, 100};
        int k = 10;
        System.out.println(new Solution().bigBusiness(a, b, k));
    }
}

