import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int len = deck.length;
        Deque<Integer> deque1 = new LinkedList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        deque.offerFirst(deck[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            deque.offerFirst(deque.pollLast());
            deque.offerFirst(deck[i]);
        }
        
        int[] result = new int[len];
        int index = 0;
        while (!deque.isEmpty()) {
            result[index++] = deque.pollFirst();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        int[] result = new Solution().deckRevealedIncreasing(deck);
        System.out.println(Arrays.toString(result));
    }
}
