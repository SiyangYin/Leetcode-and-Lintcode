import java.util.*;

public class SnakeGame {
    
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
        @Override
        public boolean equals(Object another) {
            Pair pair = (Pair) another;
            return x == pair.x && y == pair.y;
        }
    
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    int height, width;
    int score;
    int[][] food;
    int foodIdx;
    Deque<Pair> snake;
    Set<Pair> track;
    
    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.height = height;
        this.width = width;
        this.food = food;
        foodIdx = 0;
        snake = new LinkedList<>();
        snake.offer(new Pair(0, 0));
        track = new HashSet<>();
        track.add(new Pair(0, 0));
    }
    
    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        char d = direction.charAt(0);
        int x = snake.peekLast().x, y = snake.peekLast().y;
        x += d == 'D' ? 1 : 0;
        x += d == 'U' ? -1 : 0;
        y += d == 'L' ? -1 : 0;
        y += d == 'R' ? 1 : 0;
        if (!inBound(x, y)) {
            return -1;
        }
        
        Pair cur = new Pair(x, y);
        
        if (foodIdx < food.length) {
            if (x == food[foodIdx][0] && y == food[foodIdx][1]) {
                score++;
                snake.offer(cur);
                track.add(cur);
                foodIdx++;
                return score;
            }
        }
        
        Pair tail = snake.poll();
        track.remove(new Pair(tail.x, tail.y));
        if (track.contains(cur)) {
            return -1;
        }
        
        snake.offer(cur);
        track.add(cur);
        return score;
    }
    
    private boolean inBound(int x, int y) {
        return 0 <= x && x < height && 0 <= y && y < width;
    }
    
    public static void main(String[] args) {
        int[][] food = {{0, 1}};
        SnakeGame game = new SnakeGame(2, 2, food);
        String d = "RD";
        for (int i = 0; i < d.length(); i++) {
            System.out.println(game.move(String.valueOf(d.charAt(i))));
        }
    }
}
